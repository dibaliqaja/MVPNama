package com.iqbal.mymvp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    // var Presenter
    lateinit var presenter: MainPresenter

    // This view display Toast Message
    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    // This view display Data
    override fun showData(data: String) {
        // Display data on Dialog
        AlertDialog.Builder(this)
            .setTitle("Data")
            .setMessage(data)
            .setPositiveButton(
                "Close", DialogInterface.OnClickListener {
                    dialogInterface, i -> dialogInterface.dismiss()
                }
            ).show()
    }

    // This view Clear Edit Text
    override fun clearField() {
        edt_first_name.setText("")
        edt_last_name.setText("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init Presenter
        presenter = MainPresenterImp(this)

        // Event Click Listener at btn_add
        btn_add.setOnClickListener {
            // Call method addData on Presenter
            presenter.addData(edt_first_name.text.toString(), edt_last_name.text.toString())
        }

        // Event Click Listener on btn_show
        btn_show.setOnClickListener {
            // Call method loadData on Presenter
            presenter.loadData()
        }
    }
}
