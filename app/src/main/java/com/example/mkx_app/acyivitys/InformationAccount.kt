package com.example.mkx_app.acyivitys

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mkx_app.R

class InformationAccount : AppCompatActivity() {

    companion object {
        private const val READ_EXTERNAL_STORAGE = 200
        private const val OPEN_CAMERA = 201
    }

    lateinit var btnGallery:ImageButton
    lateinit var btnCamera:ImageButton

    lateinit var imgAvatar:ImageView

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

        imgAvatar = findViewById<ImageView>(R.id.ImgContainer)

    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }

    private fun openCamera(){
        Toast.makeText(this, "Camera open", Toast.LENGTH_SHORT).show()
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
}