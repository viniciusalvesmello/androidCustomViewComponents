package io.github.viniciusalvesmello.test.customs

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.test.espresso.matcher.BoundedMatcher
import io.github.viniciusalvesmello.design.components.button.CustomButton
import io.github.viniciusalvesmello.design.components.edittext.CustomEditText
import io.github.viniciusalvesmello.test.extension.ivCustomButton
import io.github.viniciusalvesmello.test.extension.pbCustomButton
import io.github.viniciusalvesmello.test.extension.tilCustomEditText
import io.github.viniciusalvesmello.test.extension.tvCustomButton
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun childOf(
    parentMatcher: Matcher<View>,
    childPosition: Int,
    checkParent: (ViewGroup) -> Boolean = { true }
): Matcher<View> = object : TypeSafeMatcher<View>() {

    override fun describeTo(description: Description?) {
        description?.appendText("with $childPosition child view of type $parentMatcher")
    }

    override fun matchesSafely(view: View): Boolean {
        val parent = view.parent

        return parent is ViewGroup &&
            parentMatcher.matches(parent) &&
            parent.childCount > childPosition &&
            parent.getChildAt(childPosition) == view &&
            checkParent(parent)
    }
}

fun appCompatCheckBoxIsChecked(isChecked: Boolean): Matcher<View> =
    object : BoundedMatcher<View, AppCompatCheckBox>(AppCompatCheckBox::class.java) {
        private var actualValue: Boolean = false

        override fun describeTo(description: Description) {
            description.appendText("appCompatCheckBoxIsChecked expected: $isChecked (actual: $actualValue)")
        }

        override fun matchesSafely(view: AppCompatCheckBox): Boolean {
            actualValue = view.isChecked

            return actualValue == isChecked
        }
    }

fun customEditTextWithText(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {
        private var actualValue: String = ""

        override fun describeTo(description: Description) {
            description.appendText("customEditTextWithText expected: $matcherText (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomEditText): Boolean {
            actualValue = view.text

            return matcherText.equals(actualValue, ignoreCase = true)
        }
    }

fun customEditTextWithHint(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {
        private var actualValue: String = ""

        override fun describeTo(description: Description) {
            description.appendText("customEditTextWithHint expected: $matcherText (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomEditText): Boolean {
            actualValue = view.tilCustomEditText().hint?.toString() ?: ""

            return matcherText.equals(actualValue, ignoreCase = true)
        }
    }

fun customEditTextWithError(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {
        private var actualValue: String = ""

        override fun describeTo(description: Description) {
            description.appendText("customEditTextWithError expected: $matcherText (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomEditText): Boolean {
            actualValue = view.error

            return matcherText.equals(actualValue, ignoreCase = true)
        }
    }

fun customEditTextIsRequired(isRequired: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomEditText>(CustomEditText::class.java) {
        private var actualValue: Boolean = false

        override fun describeTo(description: Description) {
            description.appendText("customEditTextIsRequired expected: $isRequired (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomEditText): Boolean {
            actualValue = view.required

            return actualValue == isRequired
        }
    }

fun customButtonWithText(matcherText: String): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {
        private var actualValue: String = ""

        override fun describeTo(description: Description) {
            description.appendText("customButtonWithText expected: $matcherText (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomButton): Boolean {
            actualValue = view.text

            return matcherText.equals(actualValue, ignoreCase = true)
        }
    }

fun customButtonIsLoading(isLoading: Boolean): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {
        private var actualValue: Boolean = false

        override fun describeTo(description: Description) {
            description.appendText("customButtonIsLoading expected: $isLoading (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomButton): Boolean {
            actualValue = view.isLoading

            return actualValue == isLoading
        }
    }

fun customButtonProgressBarIsVisible(isVisible: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {
        private var actualValue: Boolean = false

        override fun describeTo(description: Description) {
            description.appendText("customButtonProgressBarIsVisible expected: $isVisible (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomButton): Boolean {
            actualValue = view.pbCustomButton().visibility == View.VISIBLE

            return actualValue == isVisible
        }
    }

fun customButtonIconIsVisible(isVisible: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {
        private var iconNull: Boolean = false
        private var actualValue: Boolean = false

        override fun describeTo(description: Description) {
            if (iconNull && actualValue) {
                description.appendText("icon is null but is visible")
            } else {
                description.appendText("customButtonIconIsVisible expected: $isVisible (actual: $actualValue)")
            }
        }

        override fun matchesSafely(view: CustomButton): Boolean {
            iconNull = view.ivCustomButton().drawable == null
            actualValue = view.ivCustomButton().visibility == View.VISIBLE

            return (iconNull && !actualValue) || (!iconNull && actualValue == isVisible)
        }
    }

fun customButtonTextIsVisible(isVisible: Boolean = true): Matcher<View> =
    object : BoundedMatcher<View, CustomButton>(CustomButton::class.java) {
        private var actualValue: Boolean = false

        override fun describeTo(description: Description) {
            description.appendText("customButtonTextIsVisible expected: $isVisible (actual: $actualValue)")
        }

        override fun matchesSafely(view: CustomButton): Boolean {
            actualValue = view.tvCustomButton().visibility == View.VISIBLE

            return actualValue == isVisible
        }
    }