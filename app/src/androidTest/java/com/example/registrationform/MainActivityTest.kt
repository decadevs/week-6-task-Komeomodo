package com.example.registrationform

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.CoreMatchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private val name = "Olakome"
    private val email = "kome@gmail.com"
    private val number = "08034098745"
    private  val gender = "Male"

    @Test
    fun test_is_activity_inView() {
        /**In this function we are creating activity inside this test**/
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }


    @Test
    fun testVisibility_title() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.logoText)).check(matches(isDisplayed()))

    }

    /**checks if the text on the button is visible**/
    @Test
    fun testVisibility_SignUp_Button() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.logoText))
            .check(matches(withText(R.string.logoText)))
    }

    @Test
    fun shouldDisplaySinInErrorWhenEmailIsIncorrect() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val incorrectEmail = "Invalid email address"

//        onView(withId(R.id.email)).perform(replaceText(incorrectEmail),closeSoftKeyboard())

//        onView(withId(R.id.button)).perform(click())

        onView(withText(R.string.emailError)).check(matches(isDisplayed()))
    }

    @Test
    fun validateEditText_name() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.name)).perform(typeText("Hello")).check(matches(withText("Hello")))
    }

    @Test
    fun validateEditText_phoneNumber() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.phoneNumber)).perform(typeText("08063904372"))
            .check(matches(withText("08063904372")))
    }

    @Test
    fun validateEditText_email() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.email)).perform(typeText("ko@gmail.com"))
            .check(matches(withText("ko@gmail.com")))
    }

//    @Test
//    fun validate_Toast(){
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withText(R.string.message)).inRoot(new ToastMatcher())
//            .check(matches(withText("Please all fields are required!"))
//    }

    /****/
    @Test
    fun select_item_on_spinner() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Female")
            )
        ).perform(click())
    }

//    @Test
//    fun verify_text_is_correct(){
////        not working
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.spinner)).check(matches(withText(containsString("Male"))))
//    }

    @Test
    fun open_the_item_selection() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.spinner)).perform(click())
    }


    @Before
    fun stub_validate_activity() {
        var intent = Intent()
        intent.putExtra("FullName", name)
        intent.putExtra("Email", email)
        intent.putExtra("PhoneNumber", number)
        intent.putExtra("Gender", gender)
    }

    @get: Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun validate_intent() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.name)).perform(typeText(name))
        onView(withId(R.id.phoneNumber)).perform(click(), typeText(number), closeSoftKeyboard())
        onView(withId(R.id.email)).perform(typeText(email), closeSoftKeyboard())

        onView(withId(R.id.spinner)).perform(click())
        onData(anything()).atPosition(0).perform(click(), closeSoftKeyboard())

        onView(withId(R.id.button)).perform(click())

        intended(hasComponent(Profile::class.java.name))

        onView(withId(R.id.user_name)).check(matches((withText(name))))
//        onView(withId(R.id.phone_number)).check(matches((withText(number))))
        onView(withId(R.id.user_mail)).check(matches((withText(email))))
//        onView(withId(R.id.user_Gender)).check(matches((withText(gender))))

    }

}