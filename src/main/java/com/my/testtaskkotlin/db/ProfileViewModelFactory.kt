package com.my.testtaskkotlin.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.my.testtaskkotlin.ProfileRepository
import java.lang.IllegalArgumentException

class ProfileViewModelFactory(private val repository:ProfileRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow View Model class")
    }
}