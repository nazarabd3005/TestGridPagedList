package com.nazar.testgridandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nazar.testgridandroid.R
import com.nazar.testgridandroid.util.replaceFragment
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(R.id.container,MainFragment())

    }
}