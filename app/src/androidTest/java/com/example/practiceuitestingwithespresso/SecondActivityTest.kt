package com.example.practiceuitestingwithespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<SecondActivity>()

    // check backPress to main activity
    // check if second activity layout is displayed or not
    @Test
    fun checkSecondActivityVisibility() {
        onView(withId(R.id.second_activity_layout))
            .check(matches(isDisplayed()))
    }
    // check if "Second Activity" text is displayed as we want
    @Test
    fun checking_tv_second_activity_Visibility() {
        onView(withId(R.id.tv_second_activity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checking_btn_go_back_Visibility() {
        onView(withId(R.id.btn_go_back))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checking_tv_second_activity_ThenTextShouldBe_SecondActivity() {
        onView(withId(R.id.tv_second_activity))
            .check(matches(ViewMatchers.withText(R.string.second_activity)))
    }
}