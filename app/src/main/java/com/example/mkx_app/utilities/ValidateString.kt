package com.example.mkx_app.utilities

import android.content.Context
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.util.PatternsCompat
import com.example.mkx_app.R
import java.util.regex.Pattern

object ValidateString {

    private val passwordRegex = Pattern.compile( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}" )
    private val stringRegex = Pattern.compile( "^[a-zA-Z]*$" )
    private val digitRegex = Pattern.compile( "^[0-9]*$" )

    fun isEmail(context:Context ,label:TextView, email:String):Boolean{
        return if (email.isEmpty()){
            this.changeLabelColor(context ,label,false)
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            this.changeLabelColor(context ,label, false)
            false
        }else{
            this.changeLabelColor(context, label, true)
            true
        }
    }

    fun isPassword(context: Context, label: TextView, password:String):Boolean{
        return if (password.isEmpty()){
            this.changeLabelColor(context, label, false)
            false
        }else if (!passwordRegex.matcher(password).matches()){
            this.changeLabelColor(context, label, false)
            false
        }else{
            this.changeLabelColor(context, label, true)
            true
        }
    }

    fun isLetter(context: Context, label: TextView, string: String):Boolean{
        return if (string.isEmpty()){
            changeLabelColor(context, label, false)
            false
        }else if (!stringRegex.matcher(string).matches()){
            changeLabelColor(context, label, false)
            false
        }else{
            changeLabelColor(context, label, true)
            true
        }
    }

    fun isPhone(context: Context, label: TextView, phoneNumber:String):Boolean{
        return if (phoneNumber.isEmpty() || phoneNumber.length < 11){
            changeLabelColor(context ,label, false)
            false
        }else if (!digitRegex.matcher(phoneNumber).matches()){
            changeLabelColor(context, label, false)
            false
        }else {
            changeLabelColor(context, label, true)
            true
        }
    }

    fun isDigit(context: Context, label: TextView, digits:String):Boolean{
        return if (digits.isEmpty()){
            changeLabelColor(context ,label, false)
            false
        }else if (!digitRegex.matcher(digits).matches()){
            changeLabelColor(context, label, false)
            false
        }else {
            changeLabelColor(context, label, true)
            true
        }
    }

    fun isZipCode(context: Context, label: TextView, zipCode:String):Boolean{
        return if (zipCode.isEmpty() || zipCode.length != 6){
            changeLabelColor(context ,label, false)
            false
        }else if (!digitRegex.matcher(zipCode).matches()){
            changeLabelColor(context, label, false)
            false
        }else {
            changeLabelColor(context, label, true)
            true
        }
    }

    private fun changeLabelColor(context: Context, label: TextView, mode:Boolean){
        val orangeColor = ContextCompat.getColor(context, R.color.orange)
        val whiteColor = ContextCompat.getColor(context, R.color.primary_text)

        if (mode)
            label.setTextColor(whiteColor)
        else
            label.setTextColor(orangeColor)
    }

}