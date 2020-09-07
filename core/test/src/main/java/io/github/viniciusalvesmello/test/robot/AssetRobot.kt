package io.github.viniciusalvesmello.test.robot

import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import io.github.viniciusalvesmello.test.customs.customButtonIsLoading
import io.github.viniciusalvesmello.test.customs.customButtonWithText
import io.github.viniciusalvesmello.test.customs.customEditTextWithText
import io.github.viniciusalvesmello.test.customs.customEditTextWithError
import io.github.viniciusalvesmello.test.customs.customEditTextWithHint
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

    fun viewIsClickable(@IdRes id: Int) {
        onView(withId(id)).check(matches(ViewMatchers.isClickable()))
    }

    fun viewIsFocusable(@IdRes id: Int) {
        onView(withId(id)).check(matches(ViewMatchers.isFocusable()))
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

    fun customButtonIsLoading(@IdRes viewId: Int, loading: Boolean) {
        onView(withId(viewId)).check(matches(customButtonIsLoading(loading)))
    }

    private fun resolveVisibilityMatcher(isDisplayed: Boolean): Matcher<View> {
        return if (isDisplayed)
            ViewMatchers.isDisplayed()
        else
            ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
    }
}