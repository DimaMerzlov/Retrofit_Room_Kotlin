package com.my.testtaskkotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfileDAO {

    @Insert
    suspend fun insertProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

    @Query("DELETE FROM profile_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM profile_data_table")
    fun getAllProfile():LiveData<List<Profile>>
}