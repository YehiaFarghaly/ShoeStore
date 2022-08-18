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
   val viewModel: shoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoes, container, false)
        binding.cancelBtn.setOnClickListener { v: View ->
            backToList(v)
        }
        binding.addBtn.setOnClickListener { v: View ->
            val cp_name=binding.companyName.text.toString()
            val sh_name=binding.shoesName.text.toString()
            val desc=binding.descText.text.toString()
            val size_txt=binding.sizeTextView2.text.toString()
            if (cp_name.length == 0 || sh_name.length == 0
                || desc.length == 0 || size_txt.length == 0
            ) {
                Toast.makeText(
                    activity!!.applicationContext,
                    "Please fill all the information",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                var shoe: Shoe = Shoe(
                   sh_name,
                    size_txt.toInt(),
                    cp_name.toString(),
                    desc.toString()
                )
                viewModel.addNewShoes(shoe)
               backToList(v)
                Toast.makeText(activity!!.applicationContext, "Shoes Added", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return binding.root
    }
    fun backToList(v:View) {
        Navigation.findNavController(v).navigate(R.id.action_addShoes_to_shoes_List)
    }
}