package io.github.viniciusalvesmello.androidcustomviewcomponents.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import io.github.viniciusalvesmello.androidcustomviewcomponents.CustomButtonActivity
import io.github.viniciusalvesmello.androidcustomviewcomponents.robot.customButtonActivityAssert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CustomButtonActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(CustomButtonActivity::class.java)

    @Test
    fun givenInitialState_whenOpenScreen_shouldCheckAllData() {
        customButtonActivityAssert {
            cbPrimaryEnabledWithText("Primary")
            cbPrimaryDisabledWithText("Primary")
            cbTypeWhatsAppEnabledWithText("WhatsApp")
            cbTypeWhatsAppDisabledWithText("WhatsApp")
            cbTypeWhatsAppWithPhoneWithText("(21) 98765-5544")
            cbTypePhoneEnabledWithText("Telefone")
            cbTypePhoneDisabledWithText("Telefone")
            cbTypePhoneWithNumberWithText("(21) 98765-5544")
        }
    }
}