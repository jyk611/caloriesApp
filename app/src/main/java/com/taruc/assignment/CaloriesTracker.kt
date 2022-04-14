package com.taruc.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.taruc.assignment.model.TotalCalIntakeList
import com.taruc.assignment.view.FoodAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import com.taruc.assignment.databinding.ActivityCaloriesTrackerBinding
import com.taruc.assignment.utils.toast


class CaloriesTracker : AppCompatActivity() {

  lateinit var binding: ActivityCaloriesTrackerBinding

  private lateinit var addRBtn: FloatingActionButton
  private lateinit var recv: RecyclerView
  private lateinit var foodList: ArrayList<TotalCalIntakeList>
  private lateinit var foodAdapter: FoodAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityCaloriesTrackerBinding.inflate(layoutInflater)
    setContentView(binding.root)

    var backfoodplan = binding.backFoodplanButton.setOnClickListener {
      var Intent = Intent(this, MainActivity::class.java)
      startActivity(Intent)
    }

    var textView: TextView = binding.caloriestrackerDate

    val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy")
    val currentDateAndTime: String = simpleDateFormat.format(Date())
    textView.text = currentDateAndTime

    /**set List*/
    foodList = ArrayList()
    /**set find Id*/
    addRBtn = binding.caloriesAdd
    recv = binding.caloriesList

    /**set Adapter*/
    foodAdapter = FoodAdapter(this, foodList)
    /**setRecycler view Adapter*/
    recv.layoutManager = LinearLayoutManager(this)
    recv.adapter = foodAdapter
    /**set Dialog*/
    addRBtn.setOnClickListener { addRecord() }

  }

  private fun addRecord() {
    val inflter = LayoutInflater.from(this)
    val v = inflter.inflate(R.layout.add_total_calories_intake, null)

    /**set view*/
    val foodName = v.findViewById<EditText>(R.id.foodName)
    val foodType = v.findViewById<EditText>(R.id.foodType)
    val foodCal = v.findViewById<EditText>(R.id.foodCal)

    val addDialog = AlertDialog.Builder(this)

    addDialog.setView(v)
    addDialog.setPositiveButton("Ok") { dialog, _ ->
      val foodnames = foodName.text.toString()
      val foodtypes = foodType.text.toString()
      val foodcals = foodCal.text.toString()
      foodList.add(
        TotalCalIntakeList(
          foodName = foodnames,
          foodType = foodtypes,
          foodCal = foodcals,
          createdAt = Calendar.getInstance().time
        )
      )
      foodAdapter.notifyDataSetChanged()
      Toast.makeText(this, "Record Added Successfully", Toast.LENGTH_SHORT).show()
      dialog.dismiss()
    }
    addDialog.setNegativeButton("Cancel") { dialog, _ ->
      dialog.dismiss()
      Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()

    }
    addDialog.create()
    addDialog.show()


  }


}

