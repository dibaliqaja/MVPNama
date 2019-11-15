package com.iqbal.mymvp

interface MainView {
    // Toast Show Message Method
    fun showMessage(message:String)

    // Display data that has been processed on the presenter
    fun showData(data:String)

    // Clear Field Method
    fun clearField()
}