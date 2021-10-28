package com.example.mkx_app.models

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

object User : Person() {
    fun isNumber(number:String, activity: FragmentActivity):Boolean {
        return try {
            number.toInt()
            this.phone = number
            Toast.makeText(activity, "Number", Toast.LENGTH_SHORT).show()
            true
        }catch (e : NumberFormatException){
            Toast.makeText(activity, "Not Number", Toast.LENGTH_SHORT).show()
            false
        }
    }
}