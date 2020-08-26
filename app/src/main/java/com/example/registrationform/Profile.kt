package com.example.registrationform

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var userFullName = findViewById<TextView>(R.id.user_name)
        var userNo = findViewById<TextView>(R.id.phone_number)
        var userMail = findViewById<TextView>(R.id.user_mail)
        var userGender = findViewById<TextView>(R.id.user_gender)
        var intent = getIntent()

        val str = intent.getStringExtra("FullName")
        val mobileNumber = intent.getStringExtra("PhoneNumber")
        val email = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        userFullName.text = str
        userNo.text = mobileNumber
        userMail.text = email
        userGender.text = gender

        var back_button = findViewById<ImageButton>(R.id.back_btn)

        back_button.setOnClickListener{
            onBackPressed()
        }
    }
}