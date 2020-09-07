package io.github.viniciusalvesmello.androidcustomviewcomponents.robot

import io.github.viniciusalvesmello.androidcustomviewcomponents.R
import io.github.viniciusalvesmello.test.robot.ActionRobot
import io.github.viniciusalvesmello.test.robot.AssetRobot

class ActionCustomButtonActivity(private val robot: ActionRobot)

class AssertCustomButtonActivity(private val robot: AssetRobot) {

    fun cbPrimaryEnabledWithText(text: String) = robot.customButtonWithText(R.id.cbPrimaryEnabled, text)
    fun cbPrimaryDisabledWithText(text: String) = robot.customButtonWithText(R.id.cbPrimaryDisabled, text)
    fun cbTypeWhatsAppEnabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypeWhatsAppEnabled, text)
    fun cbTypeWhatsAppDisabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypeWhatsAppDisabled, text)
    fun cbTypeWhatsAppWithPhoneWithText(text: String) = robot.customButtonWithText(R.id.cbTypeWhatsAppWithPhone, text)
    fun cbTypePhoneEnabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypePhoneEnabled, text)
    fun cbTypePhoneDisabledWithText(text: String) = robot.customButtonWithText(R.id.cbTypePhoneDisabled, text)
    fun cbTypePhoneWithNumberWithText(text: String) = robot.customButtonWithText(R.id.cbTypePhoneWithNumber, text)
}

fun customButtonActivityAction(init: ActionCustomButtonActivity.() -> Unit) {
    ActionCustomButtonActivity(ActionRobot()).init()
}

fun customButtonActivityAssert(init: AssertCustomButtonActivity.() -> Unit) {
    AssertCustomButtonActivity(AssetRobot()).init()
}