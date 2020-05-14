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
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {

            when (isValid()) {
                0 -> Toast.makeText(this@LoginActivity, "Preencha o campo e-mail", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this@LoginActivity, "Preencha o campo password", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this@LoginActivity, "Preencha corretamente o campo e-mail", Toast.LENGTH_SHORT).show()
                else -> {
                    viewModel.getUserDb(editTextEmail.text.toString(), editTextPassword.text.toString()).observe(this, Observer {
                        it?.let {
                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                            Log.i(LoginActivity::class.java.simpleName, it.email)
                        } ?: run {
                            Toast.makeText(this@LoginActivity, "Email ou senha inválido", Toast.LENGTH_SHORT).show()
                        }

                    })
                }
            }
        }

    }

    fun isValid(): Int {
        return if (TextUtils.isEmpty(editTextEmail.text.toString())) {
            return 0
        } else if (TextUtils.isEmpty(editTextPassword.text.toString())) {
            return 1
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editTextPassword.text.toString()).matches()) {
            return 2
        } else -1
    }
}
