package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.CartItemBinding

class CartAdapter(private val cartItems: MutableList<String>,private val CartItemPrice: MutableList<String>,private val CartImage: MutableList<Int>) :RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
private val itemQuantitites = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
      holder.bind(position)
    }

    override fun getItemCount(): Int =cartItems.size


    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                cartfoodname.text=cartItems[position]
                cartitemprice.text=CartItemPrice[position]
                cartimage.setImageResource(CartImage[position])
                cartItemquantity.text=itemQuantitites[position].toString()

                minusbtn.setOnClickListener {

                }
                plusbtn.setOnClickListener {

                }
                deletebtn.setOnClickListener {
                    fun decreaseQuantity(position: Int) {
                        if (itemQuantitites[position] > 1) {
                            itemQuantitites[position]--
                            binding.cartItemquantity.text=itemQuantitites[position].toString()
                        }
                    }
                    fun increaseQuantity(position: Int) {
                        if (itemQuantitites[position] < 15) {
                            itemQuantitites[position]++
                            binding.cartItemquantity.text=itemQuantitites[position].toString()
                        }
                        
                    }
                }

            }
        }
    }
}