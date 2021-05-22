package com.example.walktracker.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "run_table")
class Run(
    var img: Bitmap? = null,  // We need typeConverter for this type
    var timeStamp: Long = 0L,
    var avgSpeedInKMH: Float = 0F,
    var distanceInMeter: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0
) {
    // Don't need to put id in constructor because Room will be automatically
    // generating the id & we won't be putting the if during object creation
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}