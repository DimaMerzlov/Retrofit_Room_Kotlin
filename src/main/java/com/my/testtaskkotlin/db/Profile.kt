package com.my.testtaskkotlin.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "profile_data_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "profile_id")
    val id:Int?=null,
    @ColumnInfo(name = "profile_name")
    val _name: String?,
    @ColumnInfo(name = "profile_mail_address")
    val _mailAddress: String?,
    @ColumnInfo(name = "profile_imageURL")
    val _imageURL: String?,
    @ColumnInfo(name = "profile_number")
    val _number: String?,
    @ColumnInfo(name = "profile_age")
    val _age: Int?

)

