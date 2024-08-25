package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.BuyagainitemBinding

class BuyAgainAdapter(private val buyAgainFoodName:ArrayList<String>,private val buAgainFoodPrice:ArrayList<String>,private val buyAgainFoodImage:ArrayList<Int>): RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {
    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodName[position],buAgainFoodPrice[position],buyAgainFoodImage[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyagainitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int =buyAgainFoodName.size
    class BuyAgainViewHolder(private val binding: BuyagainitemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(foodName: String, foodPrice: String, FoodImage: Int) {
            binding.BuyAgainFoodName.text=foodName
            binding.BuyAgainFoodPrice.text=foodPrice
            binding.BuyAgainFoodImage.setImageResource(FoodImage)
        }

    }

}