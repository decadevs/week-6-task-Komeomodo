package com.example.registrationform

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    /**instance of the validator class**/
    val validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /** create an array for the item on the spinner and an adapter**/
        val gender = arrayOf("Male","Female")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,gender)

        spinner.adapter = arrayAdapter

        var spinnerSelected = ""

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                  spinnerSelected = p0?.getItemAtPosition(p2).toString()

            }
        }

        var name = findViewById<EditText>(R.id.name)
        var phoneNumber = findViewById<EditText>(R.id.phoneNumber)
        var email = findViewById<EditText>(R.id.email)
        var button = findViewById<Button>(R.id.button)

/**Added a clickListener to the button**/
        button.setOnClickListener {
            Log.i("TAGI", "ISCLICKING!!!!!")
        if (validator.isAllValid()){
            checkedValue(name.text.toString(), phoneNumber.text.toString(), email.text.toString(), spinnerSelected)
            }else{
            Toast.makeText(this, "Please all fields are required!",Toast.LENGTH_SHORT).show()
            }

        }


        var fullNameError = findViewById<TextView>(R.id.fullNameError)
        var phoneNumberError = findViewById<TextView>(R.id.phoneNumberError)
        var emailError = findViewById<TextView>(R.id.emailError)

        var fullNameLabel = findViewById<TextView>(R.id.fullNameLabel)
        var phoneNumberLabel = findViewById<TextView>(R.id.phoneNumberLabel)
        var emailLabel = findViewById<TextView>(R.id.emailLabel)

        var fullNameBorder = name.background as GradientDrawable
        var fullNameBackground = fullNameLabel.background as GradientDrawable

        var emailBorder = email.background as GradientDrawable
        var emailLabelBackground = emailLabel.background as GradientDrawable

        var phoneNumberBorder = phoneNumber.background as GradientDrawable
        var phoneNumberLabelBackground = phoneNumberLabel.background as GradientDrawable

/** Added textChangedListener to the text to keep track on input validate as well**/
        name.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                /**this condition check if the input field is empty and it validates as well as user Enter details  **/
                if (validator.isValidName(s) && s.isNotEmpty()){
                    fullNameError.visibility = View.INVISIBLE
                    fullNameBorder.setStroke(1, ContextCompat.getColor(baseContext,R.color.secondaryDark))
                    fullNameBackground.setColor(ContextCompat.getColor(baseContext,R.color.secondaryColor))
                }else{
                    fullNameError.visibility = View.VISIBLE
                    fullNameBorder.setStroke(1, ContextCompat.getColor(baseContext,R.color.colorAccent))
                    fullNameBackground.setColor(ContextCompat.getColor(baseContext,R.color.colorAccent))
//                    if(validator.isValidName(s) && s.isNotEmpty()){
//                        fullNameLabel.setTextColor(Color.parseColor("#EEEEEE"))
//                    }else{
//                        fullNameLabel.setTextColor(Color.parseColor("#EE5F49"))
//                    }
                }
            }
        })

        email.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                /**this condition check if the input field is empty and it validates the email as well as user Enter details  **/
                if (validator.isValidEmail(s.toString()) && s.isNotEmpty()){
                    emailError.visibility = View.INVISIBLE
                    emailBorder.setStroke(1, ContextCompat.getColor(baseContext,R.color.secondaryDark))
                    emailLabelBackground.setColor(ContextCompat.getColor(baseContext,R.color.secondaryColor))
                }else{
                    emailError.visibility = View.VISIBLE
                    emailBorder.setStroke(1, ContextCompat.getColor(baseContext,R.color.colorAccent))
                    emailLabelBackground.setColor(ContextCompat.getColor(baseContext,R.color.colorAccent))
//                    if(validator.isValidEmail(s) || s.isNotEmpty()){
//                        emailLabel.setTextColor(Color.parseColor("#EEEEEE"))
//                    }else{
//                        emailLabel.setTextColor(Color.parseColor("#EE5F49"))
//                    }
                }
            }
        })
        /**this condition check if the input field is empty and it validates the email as well as user Enter details  **/
        phoneNumber.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (validator.isValidPhoneNumber(s) && s.isNotEmpty()){
                    phoneNumberError.visibility = View.INVISIBLE
                    phoneNumberBorder.setStroke(1, ContextCompat.getColor(baseContext,R.color.secondaryDark))
                    phoneNumberLabelBackground.setColor(ContextCompat.getColor(baseContext,R.color.secondaryColor))
                }else{
                    phoneNumberError.visibility = View.VISIBLE
                    phoneNumberBorder.setStroke(1, ContextCompat.getColor(baseContext,R.color.colorAccent))
                    phoneNumberLabelBackground.setColor(ContextCompat.getColor(baseContext,R.color.colorAccent))
//
                }
            }
        })

    }
/**This is implemented to send data to the next activity**/
    private fun checkedValue(name: String, email: String, phoneNumber: String, gender: String){
        var intent = Intent(this, Profile::class.java)
        intent.putExtra("FullName", name)
        intent.putExtra("Email", email)
        intent.putExtra("PhoneNumber", phoneNumber)
        intent.putExtra("Gender", gender)
        startActivity(intent)
    }

}
