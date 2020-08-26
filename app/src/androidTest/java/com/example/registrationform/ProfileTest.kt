package com.example.registrationform

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*
import org.junit.Test

class ProfileTest{
    @Test
    fun test_is_activity_inView() {
        /**In this function we are creating activity inside this test**/
        val activityScenario = ActivityScenario.launch(Profile::class.java)
//            checks for the view of the activity
        Espresso.onView(withId(R.id.secondActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibility_text() {
        val activityScenario = ActivityScenario.launch(Profile::class.java)
//        checks for Visibility of text
        Espresso.onView(withId(R.id.user_name)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        Espresso.onView(withId(R.id.phone_number)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        Espresso.onView(withId(R.id.user_mail)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        Espresso.onView(withId(R.id.user_gender)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

//    validate the back button
    @Test
    fun validate_button_click(){
        val activityScenario = ActivityScenario.launch(Profile::class.java)
        Espresso.onView(withId(R.id.back_btn)).perform(click())
    }

//    checks the visibility of the layout
    @Test
    fun testVisibility_of_layout(){
        val activityScenario = ActivityScenario.launch(Profile::class.java)
        Espresso.onView(withId(R.id.linearLayout)).check(matches(isDisplayed()))
    }
//    checks the if the icon are displayed
    @Test
    fun validate_icon(){
    val activityScenario = ActivityScenario.launch(Profile::class.java)
        Espresso.onView(withId(R.id.userImage)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.phoneLogo)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.mailLogo)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.genderLogo)).check(matches(isDisplayed()))

    }
}
