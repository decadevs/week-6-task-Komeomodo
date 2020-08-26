package com.example.registrationform
//
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class ValidatorTest {

        val validator = Validator()

        @Test
        fun testEmail(){

            Assert.assertEquals(true, validator.isValidEmail("es@gmail.com"))
            Assert.assertEquals(false, validator.isValidEmail("e s"))

        }

        @Test
        fun testEmail_isEmpty(){

            Assert.assertEquals(false, validator.isValidEmail(" "))
        }

        @Test
        fun testPhoneNumber_StartingWith234(){

            Assert.assertEquals(true, validator.isValidPhoneNumber("+2348063989964"))

        }

        @Test
        fun testPhoneNumber_StartingWith_0(){

            Assert.assertEquals(true, validator.isValidPhoneNumber("08063989964"))
        }

        @Test
        fun testPhoneNumber_NotUpTo11(){

            Assert.assertEquals(false, validator.isValidPhoneNumber("+2348063989"))
        }

        @Test
        fun testPhoneNumber_WhenEmpty(){

            Assert.assertEquals(false, validator.isValidPhoneNumber(""))
        }

        @Test
        fun testName_isEmpty(){

            Assert.assertEquals(false, validator.isValidName(""))
        }

        @Test
        fun testName_isString(){
            Assert.assertEquals(true, validator.isValidName("John Doe"))
        }


    }


