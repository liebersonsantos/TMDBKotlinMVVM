package com.liebersonsantos.tmdbkotlinmvvm.presentation.baseActivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class BaseActivity : AppCompatActivity() {
    protected fun setupToolbar(toolbar: androidx.appcompat.widget.Toolbar, titleIdRes: Int, showBackButton: Boolean = false) {
        toolbar.title = getString(titleIdRes)
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
    }
}
