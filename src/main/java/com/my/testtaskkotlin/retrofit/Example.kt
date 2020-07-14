package com.my.testtaskkotlin.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Example (
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
)
