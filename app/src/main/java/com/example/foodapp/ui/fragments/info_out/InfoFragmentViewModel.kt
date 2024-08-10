package com.example.foodapp.ui.fragments.info_out

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InfoFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val _navigateToLogin = MutableLiveData<Boolean>()
    val navigateToLogin: LiveData<Boolean>
        get() = _navigateToLogin

    fun onSignOutClicked() {
        // Set isLoggedIn to false using SharedPreferences
        val sharedPreferences = getApplication<Application>().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()

        // Trigger navigation
        _navigateToLogin.value = true
    }

    fun doneNavigating() {
        _navigateToLogin.value = false
    }
}
