package com.nazar.testgridandroid.datasource

interface PageDataSource {

    fun loadInitial()

    fun loadAfter()
}