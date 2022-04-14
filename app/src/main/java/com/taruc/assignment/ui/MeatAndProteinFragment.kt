package com.taruc.assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.taruc.assignment.R
import com.taruc.assignment.databinding.FragmentMeatAndProteinBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeatAndProteinFragment :Fragment(R.layout.fragment_meat_and_protein){

    private lateinit var binding: FragmentMeatAndProteinBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMeatAndProteinBinding.bind(view)

        binding.backFoodpyramidButton.setOnClickListener {
            val action = MeatAndProteinFragmentDirections.actionMeatAndProteinFragmentToFoodPyramidFragment()
            findNavController().navigate(action)
        }
    }



}