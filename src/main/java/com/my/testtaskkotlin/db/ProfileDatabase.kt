package com.my.testtaskkotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profile::class], version = 3)
abstract class ProfileDatabase : RoomDatabase() {
    abstract val profileDAO: ProfileDAO

    companion object {
        @Volatile
        private var INSTANCE: ProfileDatabase? = null
        fun getInstance(context: Context): ProfileDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProfileDatabase::class.java,
                        "profile_data_database"
                        ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}