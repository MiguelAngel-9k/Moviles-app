package com.example.mkx_app.acyivitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.mkx_app.R
import com.example.mkx_app.models.Address
import com.example.mkx_app.models.User
import com.example.mkx_app.utilities.ValidateString
import com.example.mkx_app.utilities.ValidateString.isDigit
import com.example.mkx_app.utilities.ValidateString.isLetter
import com.example.mkx_app.utilities.ValidateString.isZipCode


class AddressActivity : AppCompatActivity() {

    lateinit var inStreet:EditText
    lateinit var inNumber:EditText
    lateinit var inZipCode:EditText
    lateinit var inCity:EditText

    lateinit var spState:Spinner

    lateinit var lblStreet:TextView
    lateinit var lblNumber:TextView
    lateinit var lblZipCode:TextView
    lateinit var lblCity:TextView
    lateinit var lblState:TextView

    lateinit var btnFinish:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        inStreet = findViewById<EditText>(R.id.editSigninStreet)
        inNumber = findViewById<EditText>(R.id.editSigninNumber)
        inZipCode = findViewById<EditText>(R.id.editSigninZipCode)
        inCity = findViewById<EditText>(R.id.editSigninCity)
        spState = findViewById<Spinner>(R.id.spSigninState)

        lblStreet = findViewById<TextView>(R.id.txtSigninStreet)
        lblNumber = findViewById<TextView>(R.id.txtSigninNumber)
        lblZipCode = findViewById<TextView>(R.id.txtSigninZipCode)
        lblCity = findViewById<TextView>(R.id.txtSigninCity)
        lblState = findViewById<TextView>(R.id.txtSigninState)

        btnFinish = findViewById<Button>(R.id.btnFinishSignin)
        btnFinish.setOnClickListener { finishSignin() }
    }

    private fun finishSignin() {
        val validate = listOf(
            isLetter(this, lblStreet, inStreet.text.toString()),
            isZipCode(this, lblNumber, inZipCode.text.toString()),
            isLetter(this, lblCity, inCity.text.toString()),
            spState.selectedItem.toString() != "Select"
        )

        var verify = false

        validate.forEach { validation->
            if(!validation){
                verify = validation
                Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show()
                return
            }
        }

        User.setAddressInfromation(
            Address(
                inStreet.text.toString(),
                inNumber.text.toString(),
                inZipCode.text.toString(),
                inCity.text.toString(),
                spState.selectedItem.toString()
            )
        )

        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}