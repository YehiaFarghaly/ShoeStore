package com.udacity.shoestore

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentAddShoesBinding

class addShoes : Fragment() {
    lateinit var binding: FragmentAddShoesBinding
    var shoe = Shoe("",0,"","")
   val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoes, container, false)
        binding.shoeViewModel=viewModel
        binding.shoe=shoe
        binding.cancelBtn.setOnClickListener { v: View ->
            backToList(v)
        }
        return binding.root
    }
    fun backToList(v:View) {
        Navigation.findNavController(v).navigate(R.id.action_addShoes_to_shoes_List)
    }
}