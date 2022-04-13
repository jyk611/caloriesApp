package com.taruc.assignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.taruc.assignment.model.TotalCalIntakeList


@Database(
  version = 1,
  entities = [
    TotalCalIntakeList::class
  ],
  exportSchema = false
)
@TypeConverters(DbConverter::class)
abstract class FoodDb: RoomDatabase() {
  abstract fun foodDao(): FoodDao
}