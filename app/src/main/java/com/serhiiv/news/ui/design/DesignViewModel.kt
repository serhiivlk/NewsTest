package com.serhiiv.news.ui.design

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class DesignViewModel @Inject constructor() : ViewModel() {
    private val mutableText = MutableLiveData(MESSAGE)

    val text: LiveData<String>
        get() = mutableText

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(private val viewModel: DesignViewModel) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return viewModel as T
        }
    }

    companion object {
        private const val MESSAGE = "Charlotte Perriand’s “La maison au bord de l’eau”"
    }
}
