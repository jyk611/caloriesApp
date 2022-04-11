package com.taruc.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.taruc.assignment.databinding.ActivityFoodPyramidBinding

class FoodPyramid : AppCompatActivity() {

    lateinit var binding: ActivityFoodPyramidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodPyramidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var backfoodplan = binding.backFoodplanButton.setOnClickListener{
            var Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        var fatsweetpyramid = binding.fatsweetPyramid.setOnClickListener{
            var Intent = Intent(this, FatsAndSweets::class.java)
            startActivity(Intent)
        }

        var milkdiarypyramid = binding.milkdiaryPyramid.setOnClickListener{
            var Intent = Intent(this, MilkAndDiary::class.java)
            startActivity(Intent)
        }

        var meatproteinpyramid = binding.meatproteinPyramid.setOnClickListener{
            var Intent = Intent(this, MeatAndProtein::class.java)
            startActivity(Intent)
        }

        var fruitvegepyramid = binding.fruitvegePyramid.setOnClickListener{
            var Intent = Intent(this, FruitAndVegetable1::class.java)
            startActivity(Intent)
        }

        var ricegrainpyramid = binding.ricegrainPyramid.setOnClickListener{
            var Intent = Intent(this, RiceAndGrains::class.java)
            startActivity(Intent)
        }

        val toast = Toast.makeText(applicationContext, "Click on the categories to view the nutrition table!", Toast.LENGTH_SHORT)
        toast.show()


    }

}

