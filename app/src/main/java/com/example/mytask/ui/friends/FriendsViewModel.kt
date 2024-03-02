package com.example.mytask.ui.friends

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FriendsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Adil Satrio"
    }
    val text: LiveData<String> = _text
}