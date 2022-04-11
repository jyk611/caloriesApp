package com.taruc.assignment.view

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.taruc.assignment.R
import com.taruc.assignment.model.TotalCalIntakeList

class FoodAdapter(val c:Context,val foodList:ArrayList<TotalCalIntakeList>):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>()
{

    inner class FoodViewHolder(val v:View):RecyclerView.ViewHolder(v){
        var foodname:TextView
        var foodtype:TextView
        var foodcal:TextView
        var fMenus:ImageView

        init {
            foodname = v.findViewById<TextView>(R.id.fName)
            foodtype = v.findViewById<TextView>(R.id.fType)
            foodcal = v.findViewById<TextView>(R.id.fCal)
            fMenus = v.findViewById(R.id.fMenus)
            fMenus.setOnClickListener { popupMenus(it) }
        }

        private fun popupMenus(v:View) {
            val position = foodList[adapterPosition]
            val popupMenus = PopupMenu(c,v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.edit_cal_record->{
                        val v = LayoutInflater.from(c).inflate(R.layout.add_total_calories_intake,null)
                        val foodnames = v.findViewById<EditText>(R.id.foodName)
                        val foodtypes = v.findViewById<EditText>(R.id.foodType)
                        val foodcals = v.findViewById<EditText>(R.id.foodCal)
                        AlertDialog.Builder(c)
                            .setView(v)
                            .setPositiveButton("Ok"){
                                    dialog,_->
                                position.foodName = foodnames.text.toString()
                                position.foodType = foodtypes.text.toString()
                                position.foodCal = foodcals.text.toString()
                                notifyDataSetChanged()
                                Toast.makeText(c,"Calories record is edited",Toast.LENGTH_SHORT).show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("Cancel"){
                                    dialog,_->
                                dialog.dismiss()

                            }
                            .create()
                            .show()

                        true
                    }
                    R.id.delete_cal_record->{
                        /**set delete*/
                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.cal_record_warng)
                            .setMessage("Are you sure delete this record ?")
                            .setPositiveButton("Yes"){
                                    dialog,_->
                                foodList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c,"Record has been deleted",Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("No"){
                                    dialog,_->
                                dialog.dismiss()
                            }
                            .create()
                            .show()

                        true
                    }
                    else-> true
                }

            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                .invoke(menu,true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.list_total_calories_intake,parent,false)
        return FoodViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val newFoodList = foodList[position]
        holder.foodname.text = "Food Name: " + newFoodList.foodName
        holder.foodtype.text = "Food Type: " + newFoodList.foodType
        holder.foodcal.text = "Food Cal: " + newFoodList.foodCal
    }

    override fun getItemCount(): Int {
        return  foodList.size
    }
}