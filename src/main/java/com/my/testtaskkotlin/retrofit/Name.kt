package com.my.testtaskkotlin.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Name (
    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("first")
    @Expose
    var first: String? = null,

    @SerializedName("last")
    @Expose
    var last: String? = null
)