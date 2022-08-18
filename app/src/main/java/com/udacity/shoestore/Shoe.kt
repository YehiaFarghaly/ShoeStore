package com.udacity.shoestore

import android.widget.ImageView

data class Shoe(
    var name: String = "",private var size:Int=0, var company: String = "", var description: String = ""
    ) {
    fun getSize(): String {
        return size.toString()
    }
    fun setSize(s:String) {
        size = s.toInt()
    }
}