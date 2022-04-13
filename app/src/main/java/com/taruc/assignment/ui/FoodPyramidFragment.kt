package com.taruc.assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taruc.assignment.R
import com.taruc.assignment.databinding.FragmentFoodPyramidBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodPyramidFragment : Fragment(R.layout.fragment_food_pyramid) {

  private lateinit var binding: FragmentFoodPyramidBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding = FragmentFoodPyramidBinding.bind(view)
  }
}