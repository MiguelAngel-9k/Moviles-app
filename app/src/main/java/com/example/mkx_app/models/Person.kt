package com.example.mkx_app.models
open class Person(var name:String? = null, var lastName:String? = null, var email:String? = null, var pwd:String? = null, var phone:String? = null, var address: Address? = null){

    fun isEmail():Boolean{return false}
    fun isNumber(number:String):Boolean{return false}
    fun isPwd():Boolean{return false}


}