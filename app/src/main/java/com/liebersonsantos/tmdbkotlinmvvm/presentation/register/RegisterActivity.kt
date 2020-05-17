package com.liebersonsantos.tmdbkotlinmvvm.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.liebersonsantos.tmdbkotlinmvvm.R
import com.liebersonsantos.tmdbkotlinmvvm.data.database.model.User
import com.liebersonsantos.tmdbkotlinmvvm.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonInsert.setOnClickListener {
            GlobalScope.launch {
                viewModel.insertUser(User(editTextInsertName.text.toString(), editTextInsertPassword.text.toString()))
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
        }

    }
}
