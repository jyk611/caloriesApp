package com.taruc.assignment.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.taruc.assignment.R
import com.taruc.assignment.databinding.FragmentFoodCaloriesSummaryBinding
import com.taruc.assignment.viewmodel.TotalCalIntakeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCaloriesSummary: Fragment(R.layout.fragment_food_calories_summary){
    private lateinit var binding: FragmentFoodCaloriesSummaryBinding
    private val viewModel by viewModels<TotalCalIntakeViewModel>()
   // private lateinit var caloriesPieChart: PieChart
   var caloriesPieChart = binding.caloriesSummaryPiechart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFoodCaloriesSummaryBinding.bind(view)

        //viewModel.allLiveCaloriesData()

        //caloriesPieChart = findViewById(R.id.calories_summary_piechart)


        initPieChart()

        setDataToPieChart()

    }

    private fun initPieChart() {
        caloriesPieChart.setUsePercentValues(true)
        caloriesPieChart.description.text = ""
        //hollow pie chart
        caloriesPieChart.isDrawHoleEnabled = false
        caloriesPieChart.setTouchEnabled(false)
        caloriesPieChart.setDrawEntryLabels(false)
        //adding padding
        caloriesPieChart.setExtraOffsets(20f, 0f, 20f, 20f)
        caloriesPieChart.setUsePercentValues(true)
        caloriesPieChart.isRotationEnabled = false
        caloriesPieChart.setDrawEntryLabels(false)
        caloriesPieChart.legend.orientation = Legend.LegendOrientation.VERTICAL
        caloriesPieChart.legend.isWordWrapEnabled = true

    }

    private fun setDataToPieChart() {
        caloriesPieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(72f, "Android"))
        dataEntries.add(PieEntry(26f, "Ios"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))


        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        caloriesPieChart.data = data
        data.setValueTextSize(15f)
        caloriesPieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        caloriesPieChart.animateY(1400, Easing.EaseInOutQuad)

//        //create hole in center
//        caloriesPieChart.holeRadius = 58f
//        caloriesPieChart.transparentCircleRadius = 61f
//        caloriesPieChart.isDrawHoleEnabled = true
//        caloriesPieChart.setHoleColor(Color.WHITE)
//        //add text in center
//        caloriesPieChart.setDrawCenterText(true);
//        caloriesPieChart.centerText = "Calories Summary"


        caloriesPieChart.invalidate()

    }



}