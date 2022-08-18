package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLogInFragmentBindingImpl
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class welcome : Fragment() {
lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        binding.goInstructionsBtn.setOnClickListener { v:View->Navigation.findNavController(v).navigate(R.id.action_welcome_to_instructions) }
        setHasOptionsMenu(true)
        return binding.root
    }

}