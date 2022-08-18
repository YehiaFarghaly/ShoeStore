package com.udacity.shoestore

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@SuppressLint("SuspiciousIndentation")
class shoeViewModel:ViewModel() {
    private var _shoesList=MutableLiveData<MutableList<Shoe>>()
    val shoesList:LiveData<MutableList<Shoe>>
    get()=_shoesList
    init{
      _shoesList.value = mutableListOf()
        addNewShoes(Shoe("Black Star",44,"Adidas","Black Sports Shoes good for running"))
        addNewShoes(Shoe("Nice Tennis",38,"Nike","White Sports Shoes good for Playing Tennis"))
    }
    fun addNewShoes(item:Shoe) {
        _shoesList.value?.add(item)

    }

}