package com.example.registrationform

import android.text.TextUtils
import android.util.Log
import android.util.Patterns

class Validator {

   var isEmail = false
    var isNumber = false
    var isName = false

/**  This function checks if the email is valid **/
    fun isValidEmail(target: String): Boolean {

//    Log.i("TAGIIN", "sgcadahjsdbashjdf hasbfahjbsfashjbfajhsbf jhas fhjas fhj ash")

         if (TextUtils.isEmpty(target)) {
           return false
        } else {
          var check =   Patterns.EMAIL_ADDRESS.matcher(target).matches()
             isEmail = check

             return check
        }
    }

/**This function validate the Number and ensure it start with +234 or 0 **/
    fun isValidPhoneNumber(target: CharSequence): Boolean {
        var PHONE_PATTERN = "^(\\+234|0)\\d{10}$".toRegex()
        isNumber = target.matches(PHONE_PATTERN)

        return isNumber
    }

/**  this function checks if the characters are capital letters or small letter
 * it also checks if there is space between the characters**/
    fun isValidName(target: CharSequence): Boolean{
          var string = target.toString()
        var fullName = "[A-Za-z]+".toRegex()
        isName = string.replace(" ", "").matches(fullName)

        return isName
    }

/**This function returns true if all the function above return true**/
    fun isAllValid():Boolean{

        return isEmail && isName && isNumber
    }



}