package com.example.mkx_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var editEmail:EditText? = null
    var editPassword:EditText? = null
    var buttonSingin: Button? = null
    var buttonLogin: Button? = null
    var buttonContainer: ConstraintLayout? = null
    var loginEnabled: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editEmail = findViewById<EditText>(R.id.editEmail)
        editPassword = findViewById<EditText>(R.id.editPassword)
        buttonSingin = findViewById<Button>(R.id.btnSignin)
        buttonLogin = findViewById<Button>(R.id.btnLogin)
        buttonContainer = findViewById<ConstraintLayout>(R.id.buttonContainer)

        this.buttonSingin?.setOnClickListener(this)

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

    override fun onClick(v: View?) {
        when(v!!.id){
            buttonSingin?.id->{
                this.disableLogin()
                this.loadFragment(SigninFragment())
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        val fragmentTraction = supportFragmentManager.beginTransaction()
        fragmentTraction.add(R.id.signinFrame, fragment)
        fragmentTraction.commit()
    }

    private fun disableLogin(){
       if(this.loginEnabled){
           this.editEmail?.isEnabled = false
           this.editPassword?.isEnabled = false
           this.buttonSingin?.isEnabled = false

           this.loginEnabled = false
       }else if(loginEnabled!!){
           this.editEmail?.isEnabled = true
           this.editPassword?.isEnabled = true
           this.buttonSingin?.isEnabled = true

           this.loginEnabled = true
       }
    }

}