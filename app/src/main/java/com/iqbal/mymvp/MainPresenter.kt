package com.iqbal.mymvp

interface MainPresenter {
    // Add Data Method
    fun addData(firstName: String, lastName:String)

    // Data Process Method
    fun loadData()
}