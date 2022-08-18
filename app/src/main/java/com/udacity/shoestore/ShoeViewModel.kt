package com.udacity.shoestore

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

@SuppressLint("SuspiciousIndentation")
class ShoeViewModel:ViewModel() {
    private var _shoesList=MutableLiveData<MutableList<Shoe>>()
    val shoesList:LiveData<MutableList<Shoe>>
    get()=_shoesList
    init{
      _shoesList.value = mutableListOf()

        addNewShoes("Black Star","44","Adidas","Black Sports Shoes good for running")
        addNewShoes("Nice Tennis","38","Nike","White Sports Shoes good for Playing Tennis")
    }
    fun addNewShoes(name:String,size:String,company:String,desc:String)
    {
        Log.i("yehia","joined the method")
        val sz:Int = size.toInt()
        val item:Shoe = Shoe(name,sz,company,desc)
        _shoesList.value?.add(item)
    }

}