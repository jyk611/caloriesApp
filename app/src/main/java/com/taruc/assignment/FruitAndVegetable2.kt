package com.taruc.assignment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taruc.assignment.databinding.ActivityFruitAndVegetable2Binding

class FruitAndVegetable2 : AppCompatActivity() {

    lateinit var binding: ActivityFruitAndVegetable2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitAndVegetable2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var backButton = binding.backButton.setOnClickListener {
            var Intent = Intent(this,FruitAndVegetable1::class.java)
            startActivity(Intent)
        }
    }

}