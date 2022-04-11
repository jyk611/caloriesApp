package com.taruc.assignment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taruc.assignment.databinding.ActivityFruitAndVegetable1Binding

class FruitAndVegetable1 : AppCompatActivity() {

    lateinit var binding: ActivityFruitAndVegetable1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitAndVegetable1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var nextButton = binding.nextButton.setOnClickListener {
            var Intent = Intent(this, FruitAndVegetable2::class.java)
            startActivity(Intent)
        }

        var backfoodpyramid = binding.backFoodpyramidButton.setOnClickListener {
            var Intent = Intent(this, FoodPyramid::class.java)
            startActivity(Intent)
        }

    }
}