package com.example.foodorderingapp.Fragment

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodorderingapp.Adapter.PopularAdapter
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image_list=ArrayList<SlideModel>()
        image_list.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        image_list.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        image_list.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider=binding.imageSlider
        imageSlider.setImageList(image_list)
        imageSlider.setImageList(image_list,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = image_list[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }

        })

        val foodName = listOf("Burger", "Pizza", "Pasta", "Salad", "Sushi")
        val Price = listOf("$10", "$15", "$20", "$1","$6")
        val popularFoodImages= listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu1,R.drawable.menu3)
    val adapter= PopularAdapter(foodName,Price,popularFoodImages)
        binding.popularRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter=adapter

    }
}






