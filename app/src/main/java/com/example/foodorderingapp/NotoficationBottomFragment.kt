package com.example.foodorderingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.Adapter.NotificationAdapter
import com.example.foodorderingapp.databinding.FragmentNotoficationBotttomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotoficationBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotoficationBotttomBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentNotoficationBotttomBinding.inflate(layoutInflater,container,false)
        val notifications= listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImages= listOf(R.drawable.sademoji,R.drawable.car,R.drawable.orderaccepted)
        val adapter= NotificationAdapter(
            ArrayList(notifications), ArrayList(notificationImages)
        )
        binding.notificationRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}