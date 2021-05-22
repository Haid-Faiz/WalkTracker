package com.example.walktracker.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM run_table ORDER BY timeStamp DESC")
    fun getRunsByDate() : LiveData<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY timeInMillis DESC")
    fun getRunsByDuration() :  LiveData<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY avgSpeedInKMH DESC")
    fun getRunsBySpeed() : LiveData<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY distanceInMeter DESC")
    fun getRunsByDistance() : LiveData<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY caloriesBurned DESC")
    fun getRunsByCaloriesBurned() : LiveData<List<Run>>

    //----------Queries for Statistics Fragment-------------------

    @Query("SELECT SUM(timeInMillis) FROM run_table")
    fun getAllRunsTime() : LiveData<Long>

    @Query("SELECT SUM(distanceInMeter) FROM run_table")
    fun getAllRunsDistance(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM run_table")
    fun getAllRunsAvgSpeed(): LiveData<Float>

    @Query("SELECT SUM(caloriesBurned) FROm run_table")
    fun getAllRunsCaloriesBurned() : LiveData<Int>
}