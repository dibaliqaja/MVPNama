package com.iqbal.mymvp

import android.text.TextUtils

class MainPresenterImp (private val view: MainView) : MainPresenter {

    // ArrayList for Hold Data
    private val DATA = ArrayList<HashMap<String,String>>()

    // Method which exist in presenter interface
    override fun addData(firstName: String, lastName: String) {
        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)) {
            // Call view to display a message when one of the EditText is Empty
            view.showMessage("Field should not be empty")
        } else {
            // Hashmap
            val map = HashMap<String, String>()

            // Add two Value on Hashmap
            map.put("firstname", firstName)
            map.put("lastname", lastName)

            // Hashmap data that has been filled value accomodated to ArrayList
            DATA.add(map)

            // Call view for display message when data is added
            view.showMessage("Data Added")

            // Call view for Clear Edit Text
            view.clearField()
        }
    }

    // Method which exist in presenter interface
    override fun loadData() {
        if (DATA.size == 0) {
            // Call view for show message when data on ArrayList still empty
            view.showMessage("Data Empty")
        } else {
            // A String Variable with allData Name
            var allData = ""

            // To do looping for fill a variable allData with every value at ArrayList
            for (i in 0 until DATA.size) {
                allData += "First Name : " + DATA[i].get("firstname")+"\nLast Name : " + DATA[i].get("lastname")+"\n\n"
            }
            // Display the number of values in the ArrayList
            allData += "Total : " + DATA.size

            // Call view for Display Data
            view.showData(allData)
        }
    }

}