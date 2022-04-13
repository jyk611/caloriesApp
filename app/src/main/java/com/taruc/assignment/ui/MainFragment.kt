package com.taruc.assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.taruc.assignment.R
import com.taruc.assignment.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

  private lateinit var binding: FragmentMainBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding = FragmentMainBinding.bind(view)

    binding.foodpyramidPagebox.setOnClickListener {
      val action = MainFragmentDirections.actionMainFragmentToFoodPyramidFragment()
      findNavController().navigate(action)
    }

    binding.caloriestrackerPagebox.setOnClickListener {
      val action = MainFragmentDirections.actionMainFragmentToCaloriesTrackerFragment()
      findNavController().navigate(action)
    }
  }

}