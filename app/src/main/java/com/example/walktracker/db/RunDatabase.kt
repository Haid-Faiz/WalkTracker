package com.example.walktracker.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Run::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class RunDatabase : RoomDatabase() {

    abstract fun getRunDao(): RunDao

    // We will use Dagger... So, we don't need all this code by ourself
//    companion object {
//
//        @Volatile
//        private var INSTANCE: RunDatabase? = null
//
//        operator fun invoke(context: Context): RunDatabase = INSTANCE ?: synchronized(this) {
//            INSTANCE ?: createDatabase(context).apply {
//                INSTANCE = this
//                INSTANCE
//            }
//        }
//
//        private fun createDatabase(context: Context): RunDatabase = Room.databaseBuilder(
//            context.applicationContext,
//            RunDatabase::class.java,
//            "run_database"
//        ).build()
//
//    }
}