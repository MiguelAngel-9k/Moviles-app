package com.example.mkx_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var editEmail:EditText? = null
    var editPassword:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editEmail = findViewById<EditText>(R.id.editEmail)
        editPassword = findViewById<EditText>(R.id.editPassword)

        var savedEmail = savedInstanceState?.getString("user_email").toString()
        var savedPassword = savedInstanceState?.getString("user_password").toString()

        this.restoreLogin(savedEmail, savedPassword)

    }

    private fun restoreLogin(email: String?, password: String?){
       if(email == "null")
            this.editEmail?.setText("")
        else
            this.editEmail?.setText(email)

        if(password == "null")
            this.editPassword?.setText("")
        else
            this.editPassword?.setText(password)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("user_email", this.editEmail?.text.toString())
        outState.putString("user_password", this.editPassword?.text.toString())
    }
}