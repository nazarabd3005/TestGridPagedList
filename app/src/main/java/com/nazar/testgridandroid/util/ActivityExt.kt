package com.nazar.testgridandroid.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.replaceFragment(containerView: Int, fragment: Fragment) {
    if (containerView != 0) {
        val ft: FragmentTransaction =
            this.supportFragmentManager.beginTransaction()
        ft.replace(containerView, fragment, fragment.tag)
        ft.addToBackStack(fragment.javaClass.name)
        ft.commitAllowingStateLoss()
    }
}
