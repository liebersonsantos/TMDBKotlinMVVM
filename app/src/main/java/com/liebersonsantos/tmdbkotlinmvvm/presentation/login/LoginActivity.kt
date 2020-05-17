package com.liebersonsantos.tmdbkotlinmvvm.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.liebersonsantos.tmdbkotlinmvvm.R
import com.liebersonsantos.tmdbkotlinmvvm.presentation.home.view.HomeActivity
import com.liebersonsantos.tmdbkotlinmvvm.presentation.login.loginviewmodel.LoginViewModel
import com.liebersonsantos.tmdbkotlinmvvm.presentation.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        createAccount()
        login()

    }

    fun createAccount(){
        textCreateAccount.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }

    fun login(){
        button.setOnClickListener {

            when (viewModel.isValid(editTextEmail, editTextPassword)) {
                0 -> Toast.makeText(this@LoginActivity, "Preencha todos os campos para acessar o aplicativo", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this@LoginActivity, "Preencha o campo password", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this@LoginActivity, "Preencha corretamente o campo e-mail", Toast.LENGTH_SHORT).show()
                else -> {
                    viewModel.getUserDb(editTextEmail.text.toString(), editTextPassword.text.toString()).observe(this, Observer {
                        it?.let {
                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                            Log.i(LoginActivity::class.java.simpleName, it.email)
                            finish()
                        } ?: run {
                            Toast.makeText(this@LoginActivity, "Email ou senha inválido", Toast.LENGTH_SHORT).show()
                        }

                    })
                }
            }
        }
    }
}
