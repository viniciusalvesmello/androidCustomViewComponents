package io.github.viniciusalvesmello.test.customs

import android.os.IBinder
import android.view.View
import android.view.WindowManager
import androidx.test.espresso.Root
import androidx.test.espresso.matcher.BoundedMatcher
import io.github.viniciusalvesmello.design.components.button.CustomButton
import io.github.viniciusalvesmello.design.components.edittext.CustomEditText
import io.github.viniciusalvesmello.test.extension.ivCustomButton
import io.github.viniciusalvesmello.test.extension.pbCustomButton
import io.github.viniciusalvesmello.test.extension.tvCustomButton
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun customEditTextWithText(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomEditText (tietCustomEditText) -> text equal: $matcherText")
        }

        override fun matchesSafely(view: CustomEditText): Boolean =
            matcherText.equals(view.text, ignoreCase = true)
    }

fun customEditTextWithHint(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomEditText (tilCustomEditText) -> hint equal: $matcherText")
        }

        override fun matchesSafely(view: CustomEditText): Boolean =
            matcherText.equals(view.hint, ignoreCase = true)
    }

fun customEditTextWithError(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomEditText (tilCustomEditText) -> error equal: $matcherText")
        }

        override fun matchesSafely(view: CustomEditText): Boolean =
            matcherText.equals(view.error, ignoreCase = true)
    }

fun customButtonWithText(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton (tvCustomButton) -> text equal: $matcherText")
        }

        override fun matchesSafely(view: CustomButton): Boolean =
            matcherText.equals(view.text, ignoreCase = true)
    }

fun customButtonIsLoading(isLoading: Boolean): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton -> isLoading: $isLoading")
        }

        override fun matchesSafely(view: CustomButton): Boolean = view.isLoading == isLoading
    }

fun customButtonProgressBarIsVisible(isVisible: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton (pbCustomButton) -> Progress Bar isVisible: $isVisible")
        }

        override fun matchesSafely(view: CustomButton): Boolean =
            view.pbCustomButton().visibility == if(isVisible) View.VISIBLE else View.GONE
    }

fun customButtonIconIsVisible(isVisible: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton (ivCustomButton) -> Icon isVisible: $isVisible")
        }

        override fun matchesSafely(view: CustomButton): Boolean =
            (view.ivCustomButton().drawable == null && view.ivCustomButton().visibility == View.GONE) ||
            view.ivCustomButton().visibility == if(isVisible) View.VISIBLE else View.GONE
    }

fun customButtonTextIsVisible(isVisible: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton (tvCustomButton) -> Text isVisible: $isVisible")
        }

        override fun matchesSafely(view: CustomButton): Boolean =
            view.tvCustomButton().visibility == if(isVisible) View.VISIBLE else View.GONE
    }