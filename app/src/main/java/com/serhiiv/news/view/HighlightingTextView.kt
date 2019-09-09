package com.serhiiv.news.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.Layout
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.withTranslation
import com.serhiiv.news.R

class HighlightingTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var highlightPadding = 0

    private val paint = Paint().apply {
        color = ResourcesCompat.getColor(resources, android.R.color.white, null)
    }
    private val rect = Rect()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.HighlightingTextView,
            defStyleAttr,
            0
        ).run {
            try {
                highlightPadding =
                    getDimensionPixelSize(R.styleable.HighlightingTextView_highlightPadding, 0)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        if (layout != null) {
            canvas?.withTranslation(totalPaddingLeft.toFloat(), totalPaddingTop.toFloat()) {
                drawHighlight(this, layout)
            }
        }
        super.onDraw(canvas)
    }

    private fun drawHighlight(canvas: Canvas, layout: Layout) = with(layout) {
        for (i in 0 until lineCount) {
            rect.left = (getLineLeft(i) - highlightPadding).toInt()
            rect.top = getLineTopWithoutPadding(i) - highlightPadding
            rect.right = (getLineRight(i) + highlightPadding).toInt()
            rect.bottom = getLineBottomWithoutPadding(i) + highlightPadding

            canvas.drawRect(rect, this@HighlightingTextView.paint)
        }
    }
}
