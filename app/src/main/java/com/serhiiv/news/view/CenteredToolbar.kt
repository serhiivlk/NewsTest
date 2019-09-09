package com.serhiiv.citymani.core.android.view

import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.R
import androidx.appcompat.widget.Toolbar

class CenteredToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = R.attr.toolbarStyle
) : Toolbar(context, attrs, defStyle) {

    private var titleView: TextView? = null
    private var textAppearanceId = View.NO_ID

    private var textChanged = false

    init {
        val a = context.theme.obtainStyledAttributes(
            attrs,
            intArrayOf(R.attr.titleTextAppearance), defStyle, 0
        )
        try {
            textAppearanceId = a.getResourceId(0, 0)
        } finally {
            a.recycle()
        }

        initTitleTextView()
        setupTitleTextAppearance()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (textChanged || changed) {
            initTitleTextView()
            titleView?.let {
                it.x = ((width - it.width) / 2).toFloat()
            }
        }
    }

    override fun setTitle(title: CharSequence?) {
        initTitleTextView()
        titleView?.text = title
        textChanged = true
        requestLayout()
    }

    private fun initTitleTextView() {
        if (titleView == null) {
            titleView = TextView(context).apply {
                ellipsize = TextUtils.TruncateAt.END
                setSingleLine(true)
                isAllCaps = true
            }
            addView(titleView, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        }
    }

    private fun setupTitleTextAppearance() {
        val titleView = this.titleView ?: return
        if (textAppearanceId != View.NO_ID) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                titleView.setTextAppearance(textAppearanceId)
            } else {
                @Suppress("DEPRECATION")
                titleView.setTextAppearance(context, textAppearanceId)
            }
        }
    }
}
