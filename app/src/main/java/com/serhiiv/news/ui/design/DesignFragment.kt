package com.serhiiv.news.ui.design

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.serhiiv.news.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.list_item_post.*
import javax.inject.Inject

class DesignFragment : DaggerFragment() {

    @Inject
    lateinit var factory: DesignViewModel.Factory

    private val viewModel: DesignViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_design, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, this::processText)
    }

    private fun processText(text: String) {
        message.text = text
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.design, menu)
    }
}
