package com.my.testtaskkotlin.retrofit

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Dob (
    @SerializedName("date")
    @Expose
    var date: String? = null,

    @SerializedName("age")
    @Expose
    var age: Int? = null
)