package com.taruc.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.taruc.assignment.databinding.ActivityRiceAndGrainsBinding

class RiceAndGrains : AppCompatActivity() {

    lateinit var binding: ActivityRiceAndGrainsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiceAndGrainsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var backfoodpyramid = binding.backFoodpyramidButton.setOnClickListener {
            var Intent = Intent(this, FoodPyramid::class.java)
            startActivity(Intent)
        }
    }
}