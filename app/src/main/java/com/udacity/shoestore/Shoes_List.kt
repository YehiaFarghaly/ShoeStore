package com.udacity.shoestore


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.ShoesLayoutBinding


class Shoes_List : Fragment() {
    lateinit var binding: FragmentShoesListBinding
    val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes__list, container, false)
        binding.floatingActionButton.setOnClickListener { v: View ->
            Navigation.findNavController(v).navigate(R.id.action_shoes_List_to_addShoes)
        }
        viewModel.shoesList.observe(this as LifecycleOwner, Observer {
            if (viewModel.shoesList.value!!.size > 0) {
                val myLayout = binding.linearLayout
                for (item in viewModel.shoesList.value!!) {
                    Log.i("yehia","inside the loop")
                    var layout = ShoesLayoutBinding.inflate(layoutInflater)
                    layout.cpTextView2.text=item.company
                    layout.nameTextView2.text=item.name
                    layout.sizeTextView2.text=item.getSize()
                    layout.descText.text=item.description
                    myLayout.addView(layout.root)
                }
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}