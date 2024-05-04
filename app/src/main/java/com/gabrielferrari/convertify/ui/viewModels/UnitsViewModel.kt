package com.gabrielferrari.convertify.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UnitsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Units Fragment"
    }
    val text: LiveData<String> = _text
}