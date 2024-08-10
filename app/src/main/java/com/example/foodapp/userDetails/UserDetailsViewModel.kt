package com.example.foodapp.userDetails

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodapp.database.RegisterRepository
import com.example.foodapp.util.PreferencesHelper

class UserDetailsViewModel (private val repository: RegisterRepository,application: Application):AndroidViewModel(application){
    private val prefsHelper = PreferencesHelper(application)
    val users = repository.users
    init {
        Log.i("MYTAG","inside_users_Lisrt_init")
    }


    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    fun doneNavigating(){
        _navigateto.value=false
    }


    fun backButtonclicked() {
        val sharedPreferences = getApplication<Application>().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()

        _navigateto.value = true
    }

}