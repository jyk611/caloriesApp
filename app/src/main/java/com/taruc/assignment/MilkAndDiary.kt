package com.taruc.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taruc.assignment.databinding.ActivityMilkAndDiaryBinding

class MilkAndDiary : AppCompatActivity() {

    lateinit var binding: ActivityMilkAndDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMilkAndDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var backfoodpyramid = binding.backFoodpyramidButton.setOnClickListener {
            var Intent = Intent(this, FoodPyramid::class.java)
            startActivity(Intent)
        }
    }
}