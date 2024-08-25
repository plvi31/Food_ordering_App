package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.PopularItemslistBinding

class PopularAdapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>):RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
       return PopularViewHolder(PopularItemslistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
       val item = items[position]
        val images=image[position]
        val price=price[position]
        holder.bind(item,images,price)

    }
    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder(private val binding:PopularItemslistBinding) :RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageepopularlist
        fun bind(item: String, images: Int,price:String) {
            binding.foodname.text=item
            binding.pricepopular.text=price
            imagesView.setImageResource(images)

        }
    }
}