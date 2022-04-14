package com.taruc.assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.taruc.assignment.R


import com.taruc.assignment.database.FoodDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FoodCaloriesSummary @Inject constructor(
    private val foodDao: FoodDao
): Fragment() {

    val caloriesPieChartSummary = foodDao.getCaloriesPieChart()





}