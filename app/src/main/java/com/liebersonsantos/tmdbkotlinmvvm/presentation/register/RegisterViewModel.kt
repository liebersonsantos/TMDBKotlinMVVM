package com.liebersonsantos.tmdbkotlinmvvm.presentation.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.liebersonsantos.tmdbkotlinmvvm.data.database.model.User
import com.liebersonsantos.tmdbkotlinmvvm.data.database.repository.UserRepository

class RegisterViewModel(application: Application): AndroidViewModel(application) {
    
    private val repository = UserRepository(getApplication())

    suspend fun insertUser(user: User){
        repository.insertUser(user)
    }
}