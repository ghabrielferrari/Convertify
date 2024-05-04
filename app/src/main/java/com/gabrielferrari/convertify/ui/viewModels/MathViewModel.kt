package com.gabrielferrari.convertify.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MathViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Math Fragment"
    }
    val text: LiveData<String> = _text
}