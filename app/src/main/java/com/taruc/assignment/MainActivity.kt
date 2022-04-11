package com.taruc.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.taruc.assignment.databinding.ActivityMainBinding
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var foodpyramidpage = binding.foodpyramidPagebox.setOnClickListener{
            var Intent = Intent(this, FoodPyramid::class.java)
            startActivity(Intent)
        }

        var caloriestrackerpage = binding.caloriestrackerPagebox.setOnClickListener{
            var Intent = Intent(this, CaloriesTracker::class.java)
            startActivity(Intent)
        }
    }
}