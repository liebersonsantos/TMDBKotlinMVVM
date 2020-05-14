package com.liebersonsantos.tmdbkotlinmvvm.data.database.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.liebersonsantos.tmdbkotlinmvvm.data.database.model.User
import com.liebersonsantos.tmdbkotlinmvvm.data.database.UserDAO
import com.liebersonsantos.tmdbkotlinmvvm.data.database.ZupFlixDB

class UserRepository(context: Context) {

    private val userDAO: UserDAO by lazy {
        ZupFlixDB.getDataBase(context).userDao()
    }

    fun getUserDB(email: String, password: String): LiveData<User> = userDAO.getUserByEmail(email, password)

    fun getUserDBBlock(email: String, password: String): LiveData<User> {
        return userDAO.getUserByEmail(email, password)
    }

    suspend fun insertUser(user: User){
        userDAO.insertUser(user)
    }
}