package com.example.foodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.CartItemBinding

class CartAdapter(private val CartItems: MutableList<String>,private val CartItemPrice: MutableList<String>,private val CartImage: MutableList<Int>) :RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantitites = IntArray(CartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = CartItems.size


    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                cartfoodname.text = CartItems[position]
                cartitemprice.text = CartItemPrice[position]
                cartimage.setImageResource(CartImage[position])
                cartItemquantity.text = itemQuantitites[position].toString()

                minusbtn.setOnClickListener {
                    decreaseQuantity(position)

                }
                plusbtn.setOnClickListener {
                    increaseQuantity(position)

                }
                deletebtn.setOnClickListener {
                    val itemPosition=adapterPosition
                    if(itemPosition!=RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)
                    }
                }
            }
        }
        private  fun decreaseQuantity(position: Int) {
            if (itemQuantitites[position] > 1) {
                itemQuantitites[position]--
                binding.cartItemquantity.text = itemQuantitites[position].toString()
            }
        }

       private fun increaseQuantity(position: Int) {
            if (itemQuantitites[position] < 15) {
                itemQuantitites[position]++
                binding.cartItemquantity.text =
                    itemQuantitites[position].toString()
            }

        }

       private fun deleteItem(position: Int) {
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, CartItems.size)


        }
    }
}
