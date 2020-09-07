package io.github.viniciusalvesmello.test.robot

import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import io.github.viniciusalvesmello.test.customs.customButtonIconIsVisible
import io.github.viniciusalvesmello.test.customs.customButtonIsLoading
import io.github.viniciusalvesmello.test.customs.customButtonProgressBarIsVisible
import io.github.viniciusalvesmello.test.customs.customButtonTextIsVisible
import io.github.viniciusalvesmello.test.customs.customButtonWithText
import io.github.viniciusalvesmello.test.customs.customEditTextWithError
import io.github.viniciusalvesmello.test.customs.customEditTextWithHint
import io.github.viniciusalvesmello.test.customs.customEditTextWithText
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher

class AssetRobot {

    fun textIsVisible(text: String, isDisplayed: Boolean = true) {
        onView(withText(text)).check(matches(resolveVisibilityMatcher(isDisplayed)))
    }

    fun viewWithText(
        @IdRes id: Int,
        text: String,
        isDisplayed: Boolean = true
    ) {
        onView(
            CoreMatchers.allOf(withId(id), resolveVisibilityMatcher(isDisplayed))
        ).check(
            matches(withText(text))
        )
    }

    fun viewIsVisible(@IdRes id: Int, isDisplayed: Boolean = true) {
        onView(withId(id)).check(matches(resolveVisibilityMatcher(isDisplayed)))
    }

    fun viewIsNotVisible(@IdRes id: Int) {
        onView(withId(id)).check(matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }

    fun viewIsEnabled(@IdRes id: Int, isEnabled: Boolean = true) {
        if (isEnabled) {
            onView(withId(id)).check(matches(ViewMatchers.isEnabled()))
        } else {
            onView(withId(id)).check(matches(CoreMatchers.not(ViewMatchers.isEnabled())))
        }
    }

    fun customEditTextWithText(@IdRes viewId: Int, text: String) {
        onView(withId(viewId)).check(matches(customEditTextWithText(text)))
    }

    fun customEditTextWithHint(@IdRes viewId: Int, hint: String) {
        onView(withId(viewId)).check(matches(customEditTextWithHint(hint)))
    }

    fun customEditTextWithError(@IdRes viewId: Int, error: String) {
        onView(withId(viewId)).check(matches(customEditTextWithError(error)))
    }

    fun customButtonWithText(@IdRes viewId: Int, text: String) {
        onView(withId(viewId)).check(matches(customButtonWithText(text)))
    }

    fun customButtonIsLoading(@IdRes viewId: Int, isLoading: Boolean = true) {
        onView(withId(viewId)).check(matches(customButtonIsLoading(isLoading)))
        onView(withId(viewId)).check(matches(customButtonProgressBarIsVisible(isLoading)))
        onView(withId(viewId)).check(matches(customButtonIconIsVisible(!isLoading)))
        onView(withId(viewId)).check(matches(customButtonTextIsVisible(!isLoading)))
    }

    private fun resolveVisibilityMatcher(isDisplayed: Boolean): Matcher<View> =
        if (isDisplayed) {
            isDisplayed()
        } else {
            withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
        }
}