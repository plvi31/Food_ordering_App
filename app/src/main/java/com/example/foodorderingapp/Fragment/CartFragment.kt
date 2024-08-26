package com.example.foodorderingapp.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.Adapter.CartAdapter
import com.example.foodorderingapp.CongratsButtonSheet
import com.example.foodorderingapp.PayOutActivity
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentCartBinding
import com.example.foodorderingapp.databinding.FragmentHomeBinding


class CartFragment : Fragment() {
private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)

       val cartfoodName = listOf("Pizza", "Burger", "Pasta", "Salad", "Sushi")
        val cartitemPrice = listOf("$10", "$8", "$12", "$6", "$15")
        val cartitemImage = listOf(
            R.drawable.menu1,
            R.drawable.menu3,
            R.drawable.menu2,
            R.drawable.menu1,R.drawable.menu2)
        val adapter = CartAdapter(ArrayList(cartfoodName), ArrayList(cartitemPrice), ArrayList(cartitemImage))
        binding.cartRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerview.adapter = adapter

        binding.proceedButton.setOnClickListener{
            val intent= Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root



    }

    companion object {
    }
}