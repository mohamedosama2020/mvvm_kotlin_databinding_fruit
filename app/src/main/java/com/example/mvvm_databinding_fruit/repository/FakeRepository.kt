package com.example.mvvm_databinding_fruit.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

object FakeRepository {

    private val fruitNames: List<String> = listOf("Apple","Banana","Kiwi","Orange"
        ,"Strawberry","Watermelon","Raspberry")

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName:LiveData<String>
        get() = _currentRandomFruitName


    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = java.util.Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value =
            getRandomFruitName()
    }

}