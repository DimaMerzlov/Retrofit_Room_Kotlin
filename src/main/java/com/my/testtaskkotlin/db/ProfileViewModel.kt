package com.my.testtaskkotlin.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.testtaskkotlin.ProfileRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    val profiles = repository.profiles

    fun insert(profile: Profile): Job =
        viewModelScope.launch {
            repository.insert(profile)
        }

    fun update(profile: Profile): Job =
        viewModelScope.launch {
            repository.update(profile)
        }
    fun delete(profile: Profile):Job=
        viewModelScope.launch {
            repository.delete(profile)
        }
    fun clearAll():Job=
        viewModelScope.launch {
            repository.deleteAll()
        }

}
