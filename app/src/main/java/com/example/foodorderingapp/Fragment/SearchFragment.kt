package com.example.foodorderingapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.Adapter.MenuAdapter
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originalMenuFoodName = listOf("Pizza", "Burger", "Pasta", "Salad", "Sushi", "Pizza", "Burger", "Pasta", "Salad", "Sushi")
    private val originalMenuPrice = listOf("$10", "$8", "$12", "$6", "$15", "$10", "$8", "$12", "$6", "$15")
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu3,
        R.drawable.menu2,
        R.drawable.menu1, R.drawable.menu2, R.drawable.menu1,
        R.drawable.menu3,
        R.drawable.menu2,
        R.drawable.menu1, R.drawable.menu2
    )

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setupsearchview()
        showAllmenu()

        return binding.root
    }

    private fun showAllmenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuPrice)
        filteredMenuImage.addAll(originalMenuImage)
        adapter.notifyDataSetChanged()
    }

    private fun setupsearchview() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
}
