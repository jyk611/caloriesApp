package com.taruc.assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taruc.assignment.database.FoodDao
import com.taruc.assignment.database.FoodDb
import com.taruc.assignment.model.TotalCalIntakeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TotalCalIntakeViewModel @Inject constructor(
  private val foodDao: FoodDao
): ViewModel() {

  val allFood = foodDao.getAllFood()
  val allCalories = foodDao.getCalories()

  fun addFood(foodName: String, foodType: String, foodCal: String) {
    viewModelScope.launch {
      foodDao.insert(
        TotalCalIntakeList(
          foodName = foodName,
          foodType = foodType,
          foodCal = foodCal,
          createdAt = Calendar.getInstance().time
        )
      )
    }
  }

  fun deleteFood(food: TotalCalIntakeList) {
    viewModelScope.launch {
      foodDao.delete(food)
    }
  }

  fun editFood(id: Int, fName: String, fType: String, fCal: String) {
    viewModelScope.launch {
      foodDao.edit(
        id, fName, fType, fCal
      )
    }
  }
}