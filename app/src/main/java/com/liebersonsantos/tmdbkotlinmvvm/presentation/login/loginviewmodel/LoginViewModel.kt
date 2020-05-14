package com.liebersonsantos.tmdbkotlinmvvm.presentation.login.loginviewmodel

import android.app.Application
import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.liebersonsantos.tmdbkotlinmvvm.data.database.model.User
import com.liebersonsantos.tmdbkotlinmvvm.data.database.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(getApplication())

    fun getUserDb(email: String, password: String): LiveData<User>{
        return repository.getUserDB(email, password)
    }


}