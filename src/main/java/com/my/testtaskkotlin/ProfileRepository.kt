package com.my.testtaskkotlin

import com.my.testtaskkotlin.db.Profile
import com.my.testtaskkotlin.db.ProfileDAO

class ProfileRepository(private  val dao:ProfileDAO) {
    val profiles=dao.getAllProfile()

    suspend fun insert(profile: Profile){
        dao.insertProfile(profile)
    }
    suspend fun update(profile: Profile){
        dao.updateProfile(profile)
    }
    suspend fun delete(profile: Profile){
        dao.deleteProfile(profile)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}