package com.example.mkx_app.acyivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.util.PatternsCompat
import com.example.mkx_app.R
import java.util.regex.Pattern

class AccountActivity : AppCompatActivity() {

    //Inputs
    lateinit var inEmail:EditText
    lateinit var inPassword:EditText
    lateinit var inConfirmPassword:EditText

    //Labels
    lateinit var lblEmail:TextView
    lateinit var lblPassword:TextView
    lateinit var lblConfirmPassword:TextView

    //Save account button
    lateinit var btnSaveAccount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        this.inEmail = findViewById<EditText>(R.id.editSigninEmail)
        this.inPassword = findViewById<EditText>(R.id.editSigninPassword)
        this.inConfirmPassword = findViewById<EditText>(R.id.editConfrimPassword)

        this.lblEmail = findViewById<TextView>(R.id.txtSigninEmail)
        this.lblPassword = findViewById<TextView>(R.id.txtSigninPassword)
        this.lblConfirmPassword = findViewById<TextView>(R.id.txtSigninConfirmPass)

        this.btnSaveAccount = findViewById<Button>(R.id.btnSaveAccount)

        this.btnSaveAccount.setOnClickListener { this.saveAccount() }

        this.inConfirmPassword.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                changeLabelColor(lblConfirmPassword, s.toString() == inPassword.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }

    private fun isEmail(label:TextView, email:String):Boolean{
        return if (email.isEmpty()){
                this.changeLabelColor(label,false)
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                this.changeLabelColor(label, false)
            false
        }else{
                this.changeLabelColor(label, true)
            true
        }
    }
    private fun isPassword(label: TextView, password:String):Boolean{
        //At least one digit
        //At least one lowercase letter
        //At least one uppercase letter
        //At least one special character
        //At least eight character long
        val passwordRegex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}")

        return if (password.isEmpty()){
            this.changeLabelColor(label, false)
            false
        }else if (!passwordRegex.matcher(password).matches()){
            this.changeLabelColor(label, false)
            false
        }else{
            this.changeLabelColor(label, true)
            true
        }
    }

    private fun changeLabelColor(label:TextView, mode:Boolean){
        val orangeColor = ContextCompat.getColor(this, R.color.orange)
        val whiteColor = ContextCompat.getColor(this, R.color.primary_text)

        if (mode)
            label.setTextColor(whiteColor)
        else
            label.setTextColor(orangeColor)
    }

    private fun saveAccount() {

        if(this.isPassword(this.lblPassword, this.inPassword.text.toString()))
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show()

    }
}