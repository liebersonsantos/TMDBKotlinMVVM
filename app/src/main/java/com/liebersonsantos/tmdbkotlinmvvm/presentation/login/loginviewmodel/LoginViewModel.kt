package com.liebersonsantos.tmdbkotlinmvvm.presentation.login.loginviewmodel

import android.app.Application
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.liebersonsantos.tmdbkotlinmvvm.data.database.model.User
import com.liebersonsantos.tmdbkotlinmvvm.data.database.repository.UserRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(getApplication())

    fun getUserDb(email: String, password: String): LiveData<User>{
        return repository.getUserDB(email, password)
    }

    fun isValid(editEmail: EditText, editPassword: EditText): Int {
        return if (TextUtils.isEmpty(editEmail.text.toString()) && TextUtils.isEmpty(editPassword.text.toString())){
            return 0
        } else if (TextUtils.isEmpty(editPassword.text.toString())) {
            return 1
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editEmail.text.toString()).matches() || TextUtils.isEmpty(editEmail.text.toString())) {
            return 2
        } else -1
    }

}