package io.github.viniciusalvesmello.test.customs

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import io.github.viniciusalvesmello.design.components.edittext.CustomEditText
import org.hamcrest.Matcher

fun clearTextOnCustomEditText(): ViewAction =
    object : ViewAction {
        override fun getConstraints(): Matcher<View> = isAssignableFrom(CustomEditText::class.java)

        override fun getDescription(): String = "clear text on CustomEditText"

        override fun perform(uiController: UiController?, view: View?) {
           (view as? CustomEditText)?.apply {
               text = ""
           }
        }
    }

fun setTextOnCustomEditText(viewActionText: String): ViewAction =
    object : ViewAction {
        override fun getConstraints(): Matcher<View> = isAssignableFrom(CustomEditText::class.java)

        override fun getDescription(): String = "Set text $viewActionText on CustomEditText"

        override fun perform(uiController: UiController?, view: View?) {
            (view as? CustomEditText)?.apply {
                text = viewActionText
            }
        }
    }