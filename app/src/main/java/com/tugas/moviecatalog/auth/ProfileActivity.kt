package com.tugas.moviecatalog.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tugas.moviecatalog.R
import com.tugas.moviecatalog.helper.Constant
import com.tugas.moviecatalog.helper.PrefHelper
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    lateinit var prefHelper: PrefHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        prefHelper = PrefHelper(this)

        textUsername.text = prefHelper.getString( Constant.PREF_USERNAME )
        textName.text = prefHelper.getString( Constant.PREF_NAME )
        textDate.text = prefHelper.getString( Constant.PREF_DATE )
        textAddress.text = prefHelper.getString( Constant.PREF_ADDRESS )

        buttonLogout.setOnClickListener {
            prefHelper.clear()
            showMessage( "Keluar" )
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}