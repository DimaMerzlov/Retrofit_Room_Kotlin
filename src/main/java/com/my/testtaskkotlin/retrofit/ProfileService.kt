package com.my.testtaskkotlin.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ProfileService {

    @GET("api")
    fun getProfiles():Call<Example>

}