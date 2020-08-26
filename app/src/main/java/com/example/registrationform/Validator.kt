package com.example.registrationform

import android.text.TextUtils
import android.util.Log
import android.util.Patterns

class Validator {

   var isEmail = false
    var isNumber = false
    var isName = false

    fun isValidEmail(target: String): Boolean {

    Log.i("TAGIIN", "sgcadahjsdbashjdf hasbfahjbsfashjbfajhsbf jhas fhjas fhj ash")

         if (TextUtils.isEmpty(target)) {
           return false
        } else {
          var check =   Patterns.EMAIL_ADDRESS.matcher(target).matches()
             isEmail = check

             return check
        }
    }


    fun isValidPhoneNumber(target: CharSequence): Boolean {
        var PHONE_PATTERN = "^(\\+234|0)\\d{10}$".toRegex()
        isNumber = target.matches(PHONE_PATTERN)

        return isNumber
    }

    fun isValidName(target: CharSequence): Boolean{
          var string = target.toString()
        var fullName = "[A-Za-z]+".toRegex()
        isName = string.replace(" ", "").matches(fullName)

        return isName
    }


    fun isAllValid():Boolean{

        return isEmail && isName && isNumber
    }



}