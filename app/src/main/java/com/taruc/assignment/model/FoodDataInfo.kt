package com.taruc.assignment.model

interface FoodDataInfo {

    fun listFood(): ArrayList<FoodDataInfo>
    fun addFoodInfo(us:FoodDataInfo)
    fun updateFoodInfo(us:FoodDataInfo)
    fun deleteFoodInfo(id:Int)

    companion object{
        const val DATABASE_FOODCAL = "Food Calories"
    }

}