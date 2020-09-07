package io.github.viniciusalvesmello.androidcustomviewcomponents.robot

import io.github.viniciusalvesmello.androidcustomviewcomponents.R
import io.github.viniciusalvesmello.test.robot.ActionRobot
import io.github.viniciusalvesmello.test.robot.AssetRobot

object CustomButtonActivityRobot {

    fun actionRobot(init: ActionRobot.() -> Unit) {
        ActionRobot(ActionRobot()).init()
    }

    fun assertRobot(init: AssertRobot.() -> Unit) {
        AssertRobot(AssetRobot()).init()
    }

    class ActionRobot(private val robot: io.github.viniciusalvesmello.test.robot.ActionRobot) {

        fun cbPrimaryEnabledClick() = robot.clickOnView(R.id.cbPrimaryEnabled)
        fun cbTypeWhatsAppEnabledClick() = robot.clickOnView(R.id.cbTypeWhatsAppEnabled)
        fun cbTypeWhatsAppWithPhoneClick() = robot.clickOnView(R.id.cbTypeWhatsAppWithPhone)
        fun cbTypePhoneEnabledClick() = robot.clickOnView(R.id.cbTypePhoneEnabled)
        fun cbTypePhoneWithNumberClick() = robot.clickOnView(R.id.cbTypePhoneWithNumber)
    }

    class AssertRobot(private val robot: AssetRobot) {

        fun tvLastActionWithText(text: String) = robot.viewWithText(R.id.tvLastAction, text)

        fun cbPrimaryEnabledWithText(text: String) = robot.customButtonWithText(R.id.cbPrimaryEnabled, text)
        fun cbPrimaryEnabledIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbPrimaryEnabled, isEnabled)
        fun cbPrimaryEnabledIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbPrimaryEnabled, isLoading)

        fun cbPrimaryDisabledWithText(text: String) = robot.customButtonWithText(R.id.cbPrimaryDisabled, text)
        fun cbPrimaryDisabledIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbPrimaryDisabled, isEnabled)
        fun cbPrimaryDisabledIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbPrimaryDisabled, isLoading)

        fun cbTypeWhatsAppEnabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypeWhatsAppEnabled, text)
        fun cbTypeWhatsAppEnabledIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbTypeWhatsAppEnabled, isEnabled)
        fun cbTypeWhatsAppEnabledIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbTypeWhatsAppEnabled, isLoading)

        fun cbTypeWhatsAppDisabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypeWhatsAppDisabled, text)
        fun cbTypeWhatsAppDisabledIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbTypeWhatsAppDisabled, isEnabled)
        fun cbTypeWhatsAppDisabledIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbTypeWhatsAppDisabled, isLoading)

        fun cbTypeWhatsAppWithPhoneWithText(text: String) = robot.customButtonWithText(R.id.cbTypeWhatsAppWithPhone, text)
        fun cbTypeWhatsAppWithPhoneIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbTypeWhatsAppWithPhone, isEnabled)
        fun cbTypeWhatsAppWithPhoneIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbTypeWhatsAppWithPhone, isLoading)

        fun cbTypePhoneEnabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypePhoneEnabled, text)
        fun cbTypePhoneEnabledIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbTypePhoneEnabled, isEnabled)
        fun cbTypePhoneEnabledIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbTypePhoneEnabled, isLoading)

        fun cbTypePhoneDisabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypePhoneDisabled, text)
        fun cbTypePhoneDisabledIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbTypePhoneDisabled, isEnabled)
        fun cbTypePhoneDisabledIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbTypePhoneDisabled, isLoading)

        fun cbTypePhoneWithNumberWithText(text: String) = robot.customButtonWithText(R.id.cbTypePhoneWithNumber, text)
        fun cbTypePhoneWithNumberIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbTypePhoneWithNumber, isEnabled)
        fun cbTypePhoneWithNumberIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbTypePhoneWithNumber, isLoading)
    }
}