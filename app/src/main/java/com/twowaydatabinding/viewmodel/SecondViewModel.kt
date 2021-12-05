package com.twowaydatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    val name = MutableLiveData("My name is sateesh")

    fun updateName(): LiveData<String> {
        name.value = "My Name is sateesh chikkalagi"
        return name
    }
}