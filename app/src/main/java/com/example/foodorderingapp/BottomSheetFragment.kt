package com.example.foodorderingapp

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.foodorderingapp.Adapter.MenuAdapter
import com.example.foodorderingapp.databinding.FragmentBottomSheetBinding

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentBottomSheetBinding.inflate(inflater,container,false)

       binding.btnBack.setOnClickListener(){
           dismiss()
       }



        val menufoodName = listOf("Pizza", "Burger", "Pasta", "Salad", "Sushi","Pizza", "Burger", "Pasta", "Salad", "Sushi")
        val menuitemPrice = listOf("$10", "$8", "$12", "$6", "$15","$10", "$8", "$12", "$6", "$15")
        val menuitemImage = listOf(
            R.drawable.menu1,
            R.drawable.menu3,
            R.drawable.menu2,
            R.drawable.menu1,R.drawable.menu2,  R.drawable.menu1,
            R.drawable.menu3,
            R.drawable.menu2,
            R.drawable.menu1,R.drawable.menu2)
        val adapter = MenuAdapter(ArrayList(menufoodName), ArrayList(menuitemPrice), ArrayList(menuitemImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root





    }

    companion object {
    }
}