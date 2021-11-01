package com.example.mkx_app.acyivitys

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mkx_app.R
import com.example.mkx_app.models.User
import org.w3c.dom.Text
import java.io.ByteArrayOutputStream
import java.net.URI
import java.util.regex.Pattern

class InformationAccount : AppCompatActivity() {

    companion object {
        private const val READ_EXTERNAL_STORAGE = 200
        private const val OPEN_CAMERA = 201
    }

    lateinit var btnGallery:ImageButton
    lateinit var btnCamera:ImageButton

    lateinit var imgAvatar:ImageView

    lateinit var inName:EditText
    lateinit var inLastName:EditText
    lateinit var inPhone:EditText

    lateinit var lblName:TextView
    lateinit var lblLastName:TextView
    lateinit var lblPhone:TextView

    lateinit var btnContinue:Button

    private var userImage:Bitmap? = null
    var cameraActivityLauncher:ActivityResultLauncher<Intent>? = null

    private val startForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data
            imgAvatar.setImageURI(data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_account)

        btnGallery = findViewById<ImageButton>(R.id.addImage)
        btnCamera = findViewById<ImageButton>(R.id.takePicture)

        btnGallery.setOnClickListener{ checkPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE) }
        btnCamera.setOnClickListener{ checkPermissions(Manifest.permission.CAMERA, OPEN_CAMERA) }

        inName = findViewById<EditText>(R.id.editSigninName)
        inLastName = findViewById<EditText>(R.id.editSigninLatName)
        inPhone = findViewById<EditText>(R.id.editSigninPhone)

        lblName = findViewById<TextView>(R.id.txtSigninName)
        lblLastName = findViewById<TextView>(R.id.txtSigninLastname)
        lblPhone = findViewById<TextView>(R.id.txtSigninPhone)

        imgAvatar = findViewById<ImageView>(R.id.ImgContainer)

        btnContinue = findViewById<Button>(R.id.informationContinue)

        cameraActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallback { result->
            if (result.resultCode == Activity.RESULT_OK && result.data != null){
                val bundle = result.data?.extras
                userImage = bundle?.get("data") as Bitmap
                imgAvatar.setImageBitmap(userImage)
                User.avatar = getByteArrayFromBitmap(userImage as Bitmap)
            }
        })

        btnContinue.setOnClickListener{ saveInfo() }

    }

    private fun saveInfo() {
        val validations = listOf(isLetter(lblName, inName.text.toString()), isLetter(lblLastName, inLastName.text.toString()), isPhone(lblPhone, inPhone.text.toString()))
        var verify = false

        validations.forEach{ validation->
            if(!validation){
                verify = validation
                Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show()
                return
            }
        }

        User.setPersonalInfroamtion(
            inName.text.toString(),
            inLastName.text.toString(),
            inPhone.text.toString()
        )

        //Abrir intent de address activity
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }

    private fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraActivityLauncher?.launch(intent)

    }

    private fun selectAction(code: Int){
        when(code){
            READ_EXTERNAL_STORAGE->{
                openGallery()
            }
            OPEN_CAMERA->{
                openCamera()
            }
        }
    }

    private fun checkPermissions(permission:String, code:Int){

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) selectAction(code)

        when{
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED ->{
                selectAction(code)
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this, permission) ->{
                //Permissions denied already
                Toast.makeText(this, "Permissions denied already", Toast.LENGTH_SHORT).show()

                return
            }else -> {
                //Request permissions
                ActivityCompat.requestPermissions(this, arrayOf(permission), code)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            READ_EXTERNAL_STORAGE ->{
                //If permission is cancelled the result array will be empty
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openGallery()
                }else{
                    //Permissions Denied for the first time
                    Toast.makeText(this, "Permissions Denied for the first time", Toast.LENGTH_SHORT).show()

                }
            }
            OPEN_CAMERA->{
                //If permission is cancelled the result array will be empty
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera()
                }else{
                    //Permissions Denied for the first time
                    Toast.makeText(this, "Permissions Denied for the first time", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    //Bitmap to byte array
    private fun getByteArrayFromBitmap(bitmap:Bitmap):ByteArray{
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
    //Byte array from bitmap
    private fun getBitmapFromByteArray(data: ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(data, 0, data.size)
    }

    //Only letters
    private fun isLetter(label: TextView, string: String):Boolean{
        val stringRegex = Pattern.compile("^[a-zA-Z]*$")

        return if (string.isEmpty()){
            changeLabelColor(label, false)
            false
        }else if (!stringRegex.matcher(string).matches()){
            changeLabelColor(label, false)
            false
        }else{
            changeLabelColor(label, true)
            true
        }
    }

    //Is a phone number
    private fun isPhone(label: TextView, phoneNumber:String):Boolean{
        val phoneNumberRegex = Pattern.compile("^[0-9]*$")

        return if (phoneNumber.isEmpty() || phoneNumber.length < 11){
            changeLabelColor(label, false)
            false
        }else if (!phoneNumberRegex.matcher(phoneNumber).matches()){
            changeLabelColor(label, false)
            false
        }else {
            changeLabelColor(label, true)
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
}