package com.example.mvvm_databinding_fruit.viewModel

import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.mvvm_databinding_fruit.repository.FakeRepository

 class MainViewModel: ViewModel() {

    val currentRandomFruitName: LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val _displayEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent:LiveData<String>
        get() = _displayEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        editTextContent.value = FakeRepository.getRandomFruitName()
    }

}