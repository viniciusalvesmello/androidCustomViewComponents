package io.github.viniciusalvesmello.androidcustomviewcomponents.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import io.github.viniciusalvesmello.androidcustomviewcomponents.CustomButtonActivity
import io.github.viniciusalvesmello.androidcustomviewcomponents.robot.CustomButtonActivityRobot.actionRobot
import io.github.viniciusalvesmello.androidcustomviewcomponents.robot.CustomButtonActivityRobot.assertRobot
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
        assertRobot {
            tvLastActionWithText("Last Action: None")

            cbPrimaryEnabledWithText("Primary")
            cbPrimaryEnabledIsEnabled(true)
            cbPrimaryEnabledIsLoading(false)

            cbPrimaryDisabledWithText("Primary")
            cbPrimaryDisabledIsEnabled(false)
            cbPrimaryDisabledIsLoading(false)

            cbTypeWhatsAppEnabledWithText("WhatsApp")
            cbTypeWhatsAppEnabledIsEnabled(true)
            cbTypeWhatsAppEnabledIsLoading(false)

            cbTypeWhatsAppDisabledWithText("WhatsApp")
            cbTypeWhatsAppDisabledIsEnabled(false)
            cbTypeWhatsAppDisabledIsLoading(false)

            cbTypeWhatsAppWithPhoneWithText("(21) 98765-5544")
            cbTypeWhatsAppWithPhoneIsEnabled(true)
            cbTypeWhatsAppWithPhoneIsLoading(false)

            cbTypePhoneEnabledWithText("Telefone")
            cbTypePhoneEnabledIsEnabled(true)
            cbTypePhoneEnabledIsLoading(false)

            cbTypePhoneDisabledWithText("Telefone")
            cbTypePhoneDisabledIsEnabled(false)
            cbTypePhoneDisabledIsLoading(false)

            cbTypePhoneWithNumberWithText("(21) 98765-5544")
            cbTypePhoneWithNumberIsEnabled(true)
            cbTypePhoneWithNumberIsLoading(false)
        }
    }

    @Test
    fun givenButtonPrimaryEnabled_whenClick_shouldCheckLastActionAndLoadingButton() {
        actionRobot {
            cbPrimaryEnabledClick()
        }
        assertRobot {
            tvLastActionWithText("Last Action: Primary")
            cbPrimaryEnabledIsLoading(true)
        }
    }

    @Test
    fun givenButtonWhatsAppEnabled_whenClick_shouldCheckLastActionAndLoadingButton() {
        actionRobot {
            cbTypeWhatsAppEnabledClick()
        }
        assertRobot {
            tvLastActionWithText("Last Action: WhatsApp")
            cbTypeWhatsAppEnabledIsLoading(true)
        }
    }

    @Test
    fun givenButtonWhatsAppWithNumberPhone_whenClick_shouldCheckLastActionAndLoadingButton() {
        actionRobot {
            cbTypeWhatsAppWithPhoneClick()
        }
        assertRobot {
            tvLastActionWithText("Last Action: (21) 98765-5544")
            cbTypeWhatsAppWithPhoneIsLoading(true)
        }
    }

    @Test
    fun givenButtonPhoneEnabled_whenClick_shouldCheckLastActionAndLoadingButton() {
        actionRobot {
            cbTypePhoneEnabledClick()
        }
        assertRobot {
            tvLastActionWithText("Last Action: Telefone")
            cbTypePhoneEnabledIsLoading(true)
        }
    }

    @Test
    fun givenButtonPhoneWithNumber_whenClick_shouldCheckLastActionAndLoadingButton() {
        actionRobot {
            cbTypePhoneWithNumberClick()
        }
        assertRobot {
            tvLastActionWithText("Last Action: (21) 98765-5544")
            cbTypePhoneWithNumberIsLoading(true)
        }
    }
}