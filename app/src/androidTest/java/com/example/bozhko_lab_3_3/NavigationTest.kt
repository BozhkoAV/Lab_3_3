package com.example.bozhko_lab_3_3

import android.content.pm.ActivityInfo
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.action.ViewActions.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun launchMainActivity() {
        scenario = launchActivity()
    }

    @Test
    fun testAbout() {
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun testAbout2() {
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun testAbout3() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun testNav12() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))
    }

    @Test
    fun testNav123() {
        onView(withId(R.id.bnToSecond)).check(matches(withText(R.string.title_to_second)))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).check(matches(withText(R.string.title_to_first)))
        onView(withId(R.id.bnToThird)).check(matches(withText(R.string.title_to_third)))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).check(matches(withText(R.string.title_to_first)))
        onView(withId(R.id.bnToSecond)).check(matches(withText(R.string.title_to_second)))
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))
    }

    @Test
    fun testNav121() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))
    }

    @Test
    fun testNav1231() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))
    }

    @Test
    fun testNav1232() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))
    }

    @Test
    fun testBackAbout() {
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).perform(pressBack())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        // 1-2
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).perform(pressBack())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1-2-3
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))

        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_about)).perform(pressBack())
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))
    }

    @Test
    fun testBack123() {
        // 1-2
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1
        onView(withId(R.id.activity2)).perform(pressBack())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        // 1-2
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1-2-3
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))

        // 1-2
        onView(withId(R.id.activity3)).perform(pressBack())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1
        onView(withId(R.id.activity2)).perform(pressBack())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        //
        onView(withId(R.id.activity1)).perform(pressBackUnconditionally())
    }

    @Test
    fun testBack1231() {
        // 1-2
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1-2-3
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))

        // 1 (если было бы неверно, то было бы 1-2-3-1)
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        //
        onView(withId(R.id.activity1)).perform(pressBackUnconditionally())
    }

    @Test
    fun testBack1232() {
        // 1-2
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1-2-3
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))

        // 1-2 (если было бы неверно, то было бы 1-2-3-2)
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1
        onView(withId(R.id.activity2)).perform(pressBack())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        //
        onView(withId(R.id.activity1)).perform(pressBackUnconditionally())
    }

    @Test
    fun testBack12321() {
        // 1-2
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1-2-3
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))

        // 1-2 (если было бы неверно, то было бы 1-2-3-2)
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))

        // 1 (если было бы неверно, то было бы 1-2-3-2-1)
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        //
        onView(withId(R.id.activity1)).perform(pressBackUnconditionally())
    }

    @Test
    fun testRecreate() {
        scenario.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        onView(withId(R.id.activity1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(withText(R.string.title_to_second)))
        onView(withId(R.id.bnToSecond)).perform(click())

        val scenario2 = launchActivity<SecondActivity>()
        scenario2.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        onView(withId(R.id.activity2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(withText(R.string.title_to_first)))
        onView(withId(R.id.bnToThird)).check(matches(withText(R.string.title_to_third)))
        openAbout()

        val scenario3 = launchActivity<AboutActivity>()
        scenario3.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(matches(withText(R.string.title_to_third)))
        onView(withId(R.id.textView)).check(matches(withText("TextAbout")))
        onView(withId(R.id.bnToThird)).perform(click())

        val scenario4 = launchActivity<ThirdActivity>()
        scenario4.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        onView(withId(R.id.activity3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(withText(R.string.title_to_first)))
        onView(withId(R.id.bnToSecond)).check(matches(withText(R.string.title_to_second)))
    }
}