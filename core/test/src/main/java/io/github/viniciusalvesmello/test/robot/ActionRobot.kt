package io.github.viniciusalvesmello.test.robot

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import io.github.viniciusalvesmello.test.customs.clearTextOnCustomEditText
import io.github.viniciusalvesmello.test.customs.setTextOnCustomEditText
import org.hamcrest.CoreMatchers

class ActionRobot {
    fun fillCustomEditText(@IdRes viewId: Int, text: String) {
        onView(ViewMatchers.withId(viewId)).perform(
            clearTextOnCustomEditText(),
            setTextOnCustomEditText(text),
            closeSoftKeyboard()
        )
    }

    fun clickOnView(@IdRes viewId: Int) {
        onView(CoreMatchers.allOf(ViewMatchers.withId(viewId), isDisplayed())).perform(click())
    }
}