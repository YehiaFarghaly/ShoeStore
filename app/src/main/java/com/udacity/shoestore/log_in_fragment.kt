package com.udacity.shoestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.*;
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLogInFragmentBinding

class log_in_fragment : Fragment() {
lateinit var binding:FragmentLogInFragmentBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
  binding=DataBindingUtil.inflate(inflater,R.layout.fragment_log_in_fragment, container, false)
        binding.loginButton.setOnClickListener {
                v:View->
            var mail:String=binding.emailText.text.toString()
            var pass:String = binding.passText.text.toString()
            if(mail.length!=0 && pass.length!=0)
            Navigation.findNavController(v).navigate(R.id.action_log_in_fragment_to_welcome)
        else Toast.makeText(activity!!.applicationContext,"Please Enter your mail and password", Toast.LENGTH_LONG).show()
        }
       return binding.root
    }


   }