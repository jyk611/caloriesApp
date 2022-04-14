package com.taruc.assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.taruc.assignment.R
import com.taruc.assignment.databinding.FragmentFatsAndSweetsBinding
import com.taruc.assignment.databinding.FragmentMilkAndDiaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MilkAndDiaryFragment : Fragment(R.layout.fragment_milk_and_diary){
   private lateinit var binding: FragmentMilkAndDiaryBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMilkAndDiaryBinding.bind(view)

        binding.backFoodpyramidButton.setOnClickListener {
            val action = MilkAndDiaryFragmentDirections.actionMilkAndDiaryFragmentToFoodPyramidFragment()
            findNavController().navigate(action)
        }
    }

}