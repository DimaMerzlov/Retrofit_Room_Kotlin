package com.my.testtaskkotlin.retrofit

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.my.testtaskkotlin.retrofit.Dob

data class Result (
    @SerializedName("gender")
    @Expose
    var gender: String? = null,

    @SerializedName("name")
    @Expose
    var name: Name? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("dob")
    @Expose
    var dob: Dob? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("cell")
    @Expose
    var cell: String? = null,


    @SerializedName("picture")
    @Expose
    var picture: Picture? = null
    )