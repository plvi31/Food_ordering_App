package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.Adapter.BuyAgainAdapter
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
private lateinit var binding: FragmentHistoryBinding
private lateinit var buyagainAdapter:BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setUpRecyclerView()
        return binding.root

    }

    private fun setUpRecyclerView(){
        val buyAgainFoodName= arrayListOf("Pizza","Burger","Pizza","Burger","Pizza","Burger")
        val buyAgainFoodPrice= arrayListOf("$10","$2","$10","$2","$10","$2")
        val buyAgainFoodImage= arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)
        buyagainAdapter= BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyAgainRecyclerView.adapter=buyagainAdapter
        binding.buyAgainRecyclerView.layoutManager= LinearLayoutManager(requireContext())
    }

    companion object {

    }
}