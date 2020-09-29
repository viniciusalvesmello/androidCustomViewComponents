package io.github.viniciusalvesmello.androidcustomviewcomponents.robot

import io.github.viniciusalvesmello.androidcustomviewcomponents.R
import io.github.viniciusalvesmello.test.robot.ActionRobot
import io.github.viniciusalvesmello.test.robot.AssertRobot

object CustomEditTextActivityRobot {

    fun actionRobot(init: ActionRobot.() -> Unit) {
        ActionRobot(ActionRobot()).init()
    }

    fun assertRobot(init: AssertRobot.() -> Unit) {
        AssertRobot(AssertRobot()).init()
    }

    class ActionRobot(private val robot: io.github.viniciusalvesmello.test.robot.ActionRobot){

        fun fillTextField(text: String) = robot.fillCustomEditText(R.id.cetText, text)
        fun clickCheckBoxTextRequired() = robot.clickOnView(R.id.mcbTextRequired)

        fun fillNumberField(text: String) = robot.fillCustomEditText(R.id.cetNumber, text)
        fun clickCheckBoxNumberRequired() = robot.clickOnView(R.id.mcbNumberRequired)

        fun fillMoneyField(text: String) = robot.fillCustomEditText(R.id.cetMoney, text)
        fun clickCheckBoxMoneyRequired() = robot.clickOnView(R.id.mcbMoneyRequired)

        fun fillPhoneField(text: String) = robot.fillCustomEditText(R.id.cetPhone, text)
        fun clickCheckBoxPhoneRequired() = robot.clickOnView(R.id.mcbPhoneRequired)

        fun fillCPFField(text: String) = robot.fillCustomEditText(R.id.cetCPF, text)
        fun clickCheckBoxCPFRequired() = robot.clickOnView(R.id.mcbCPFRequired)

        fun fillCNPJField(text: String) = robot.fillCustomEditText(R.id.cetCNPJ, text)
        fun clickCheckBoxCNPJRequired() = robot.clickOnView(R.id.mcbCNPJRequired)

        fun clickValidate() = robot.clickOnView(R.id.cbValidate)
    }

    class AssertRobot(private val robot: io.github.viniciusalvesmello.test.robot.AssertRobot) {

        fun textFieldWithText(text: String) = robot.customEditTextWithText(R.id.cetText, text)
        fun textFieldWithHint(hint: String) = robot.customEditTextWithHint(R.id.cetText, hint)
        fun textFieldWithError(error: String) = robot.customEditTextWithError(R.id.cetText, error)
        fun textFieldIsRequired(isRequired: Boolean) = robot.customEditTextIsRequired(R.id.cetText, isRequired)
        fun checkBoxTextRequiredIsChecked(isChecked: Boolean) = robot.appCompatCheckBoxIsChecked(R.id.mcbTextRequired, isChecked)

        fun numberFieldWithText(text: String) = robot.customEditTextWithText(R.id.cetNumber, text)
        fun numberFieldWithHint(hint: String) = robot.customEditTextWithHint(R.id.cetNumber, hint)
        fun numberFieldWithError(error: String) = robot.customEditTextWithError(R.id.cetNumber, error)
        fun numberFieldIsRequired(isRequired: Boolean) = robot.customEditTextIsRequired(R.id.cetNumber, isRequired)
        fun checkBoxNumberRequiredIsChecked(isChecked: Boolean) = robot.appCompatCheckBoxIsChecked(R.id.mcbNumberRequired, isChecked)

        fun moneyFieldWithText(text: String) = robot.customEditTextWithText(R.id.cetMoney, text)
        fun moneyFieldWithHint(hint: String) = robot.customEditTextWithHint(R.id.cetMoney, hint)
        fun moneyFieldWithError(error: String) = robot.customEditTextWithError(R.id.cetMoney, error)
        fun moneyFieldIsRequired(isRequired: Boolean) = robot.customEditTextIsRequired(R.id.cetMoney, isRequired)
        fun checkBoxMoneyRequiredIsChecked(isChecked: Boolean) = robot.appCompatCheckBoxIsChecked(R.id.mcbMoneyRequired, isChecked)

        fun phoneFieldWithText(text: String) = robot.customEditTextWithText(R.id.cetPhone, text)
        fun phoneFieldWithHint(hint: String) = robot.customEditTextWithHint(R.id.cetPhone, hint)
        fun phoneFieldWithError(error: String) = robot.customEditTextWithError(R.id.cetPhone, error)
        fun phoneFieldIsRequired(isRequired: Boolean) = robot.customEditTextIsRequired(R.id.cetPhone, isRequired)
        fun checkBoxPhoneRequiredIsChecked(isChecked: Boolean) = robot.appCompatCheckBoxIsChecked(R.id.mcbPhoneRequired, isChecked)

        fun cpfFieldWithText(text: String) = robot.customEditTextWithText(R.id.cetCPF, text)
        fun cpfFieldWithHint(hint: String) = robot.customEditTextWithHint(R.id.cetCPF, hint)
        fun cpfFieldWithError(error: String) = robot.customEditTextWithError(R.id.cetCPF, error)
        fun cpfFieldIsRequired(isRequired: Boolean) = robot.customEditTextIsRequired(R.id.cetCPF, isRequired)
        fun checkBoxCPFRequiredIsChecked(isChecked: Boolean) = robot.appCompatCheckBoxIsChecked(R.id.mcbCPFRequired, isChecked)

        fun cnpjFieldWithText(text: String) = robot.customEditTextWithText(R.id.cetCNPJ, text)
        fun cnpjFieldWithHint(hint: String) = robot.customEditTextWithHint(R.id.cetCNPJ, hint)
        fun cnpjFieldWithError(error: String) = robot.customEditTextWithError(R.id.cetCNPJ, error)
        fun cnpjFieldIsRequired(isRequired: Boolean) = robot.customEditTextIsRequired(R.id.cetCNPJ, isRequired)
        fun checkBoxCNPJRequiredIsChecked(isChecked: Boolean) = robot.appCompatCheckBoxIsChecked(R.id.mcbCNPJRequired, isChecked)

        fun validateButtonWithText(text: String) = robot.customButtonWithText(R.id.cbValidate, text)
        fun validateButtonIsEnabled(isEnabled: Boolean) = robot.viewIsEnabled(R.id.cbValidate, isEnabled)
        fun validateButtonIsLoading(isLoading: Boolean) = robot.customButtonIsLoading(R.id.cbValidate, isLoading)
    }
}