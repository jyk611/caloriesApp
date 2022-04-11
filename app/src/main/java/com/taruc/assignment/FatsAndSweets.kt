package com.taruc.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taruc.assignment.databinding.ActivityFatsAndSweetsBinding

class FatsAndSweets : AppCompatActivity() {

    lateinit var binding: ActivityFatsAndSweetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFatsAndSweetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var backfoodpyramid = binding.backFoodpyramidButton.setOnClickListener{
            var Intent = Intent(this, FoodPyramid::class.java)
            startActivity(Intent)
        }

    }
}