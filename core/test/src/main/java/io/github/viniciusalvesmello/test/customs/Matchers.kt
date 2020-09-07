package io.github.viniciusalvesmello.test.customs

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import io.github.viniciusalvesmello.design.components.button.CustomButton
import io.github.viniciusalvesmello.design.components.edittext.CustomEditText
import io.github.viniciusalvesmello.test.extension.pbCustomButton
import io.github.viniciusalvesmello.test.extension.tietCustomEditText
import io.github.viniciusalvesmello.test.extension.tilCustomEditText
import io.github.viniciusalvesmello.test.extension.tvCustomButton
import org.hamcrest.Description
import org.hamcrest.Matcher

fun customEditTextWithText(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomEditText (tietCustomEditText) -> text equal: $matcherText")
        }

        override fun matchesSafely(view: CustomEditText): Boolean =
            matcherText.equals(view.tietCustomEditText().text.toString(), ignoreCase = true)
    }

fun customEditTextWithHint(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomEditText (tilCustomEditText) -> hint equal: $matcherText")
        }

        override fun matchesSafely(view: CustomEditText): Boolean =
            matcherText.equals(view.tilCustomEditText().hint.toString(), ignoreCase = true)
    }

fun customEditTextWithError(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomEditText (tilCustomEditText) -> error equal: $matcherText")
        }

        override fun matchesSafely(view: CustomEditText): Boolean =
            matcherText.equals(view.tilCustomEditText().error.toString(), ignoreCase = true)
    }

fun customButtonWithText(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton (tvCustomButton) -> text equal: $matcherText")
        }

        override fun matchesSafely(view: CustomButton): Boolean =
            matcherText.equals(view.tvCustomButton().text.toString(), ignoreCase = true)
    }

fun customButtonIsLoading(loading: Boolean): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("CustomButton (pbCustomButton) -> visibility: ${if (loading) "VISIBLE" else "GONE"}")
        }

        override fun matchesSafely(view: CustomButton): Boolean =
            view.pbCustomButton().visibility == if (loading) View.VISIBLE else View.GONE
    }