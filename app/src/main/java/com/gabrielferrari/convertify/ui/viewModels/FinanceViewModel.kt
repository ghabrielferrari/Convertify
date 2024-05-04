package com.gabrielferrari.convertify.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FinanceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Finance Fragment"
    }
    val text: LiveData<String> = _text
}