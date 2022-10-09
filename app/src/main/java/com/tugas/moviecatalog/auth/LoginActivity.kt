package com.tugas.moviecatalog.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tugas.moviecatalog.MainActivity
import com.tugas.moviecatalog.R
import com.tugas.moviecatalog.helper.Constant
import com.tugas.moviecatalog.helper.PrefHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefHelper = PrefHelper(this)

        buttonLogin.setOnClickListener {
            if (editUsername.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                saveSession( editUsername.text.toString(), editPassword.text.toString() )
                showMessage( "Berhasil login" )
                moveIntent()
            }
        }

    }


    override fun onStart() {
        super.onStart()
        if (prefHelper.getBoolean( Constant.PREF_IS_LOGIN )) {
            moveIntent()
        }
    }

    private fun saveSession(username: String, password: String){
        prefHelper.put( Constant.PREF_USERNAME, username )
        prefHelper.put( Constant.PREF_PASSWORD, password )
        prefHelper.put( Constant.PREF_IS_LOGIN, true)
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}