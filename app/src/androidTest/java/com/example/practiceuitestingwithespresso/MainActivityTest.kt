package com.example.practiceuitestingwithespresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    // check if main activity layout is displayed or not
    @Test
    fun checkMainActivityVisibility() {
        onView(withId(R.id.main_activity_layout))
            .check(matches(isDisplayed()))
    }
    // check if "Main Activity" text is displayed as we want
    @Test
    fun checking_tv_main_activity_Visibility() {
        onView(withId(R.id.tv_main_activity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checking_btn_go_to_second_activity_Visibility() {
        onView(withId(R.id.btn_go_to_second_activity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checking_tv_main_activity_ThenTextShouldBe_MainActivity() {
        onView(withId(R.id.tv_main_activity))
            .check(matches(withText(R.string.main_activity)))
    }

    // testing click in button (Main Activity) if after the click we navigate to SecondActivity
    // and test if our view is second activity layout
    @Test
    fun checking_btn_go_to_second_activity_Click_ShouldNavigateToSecondActivity() {
        onView(withId(R.id.btn_go_to_second_activity))
            .perform(click())

        onView(withId(R.id.second_activity_layout))
            .check(matches(isDisplayed()))
    }

    // check backPress to main activity
    @Test
    fun checkBackPress_ThenNavigateToMainActivity(){
        onView(withId(R.id.btn_go_to_second_activity))
            .perform(click())
        onView(withId(R.id.second_activity_layout))
            .check(matches(isDisplayed()))

        Espresso.pressBack()

        onView(withId(R.id.main_activity_layout))
            .check(matches(isDisplayed()))
    }
}