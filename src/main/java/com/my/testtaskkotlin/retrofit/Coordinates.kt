package com.my.testtaskkotlin.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coordinates (
    @SerializedName("latitude")
    @Expose
    var latitude: String? = null,

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null

)