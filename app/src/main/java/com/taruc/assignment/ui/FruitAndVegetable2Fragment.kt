package com.taruc.assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.taruc.assignment.R
import com.taruc.assignment.databinding.FragmentFruitAndVegetable2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitAndVegetable2Fragment : Fragment(R.layout.fragment_fruit_and_vegetable2){
    private lateinit var binding : FragmentFruitAndVegetable2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFruitAndVegetable2Binding.bind(view)

        binding.backButton.setOnClickListener {
            val action = FruitAndVegetable2FragmentDirections.actionFruitAndVegetable2FragmentToFruitAndVegetable1Fragment()
            findNavController().navigate(action)
        }
    }
}