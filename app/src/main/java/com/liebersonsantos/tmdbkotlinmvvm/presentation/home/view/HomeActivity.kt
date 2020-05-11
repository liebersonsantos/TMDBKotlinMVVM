package com.liebersonsantos.tmdbkotlinmvvm.presentation.home.view

import android.os.Bundle
import com.liebersonsantos.tmdbkotlinmvvm.R
import com.liebersonsantos.tmdbkotlinmvvm.presentation.baseActivity.BaseActivity
import com.liebersonsantos.tmdbkotlinmvvm.presentation.pageadapter.HomePageAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : BaseActivity() {

    val fragmentAdapter = HomePageAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupToolbar(toolbarMain, R.string.text_toolbar_home)

        viewpagerMain.adapter = fragmentAdapter
        tabsMain.setupWithViewPager(viewpagerMain)

    }

}