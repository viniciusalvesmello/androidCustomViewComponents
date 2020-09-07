package io.github.viniciusalvesmello.androidcustomviewcomponents.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import io.github.viniciusalvesmello.androidcustomviewcomponents.CustomEditTextActivity
import io.github.viniciusalvesmello.androidcustomviewcomponents.robot.CustomEditTextActivityRobot.actionRobot
import io.github.viniciusalvesmello.androidcustomviewcomponents.robot.CustomEditTextActivityRobot.assertRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CustomEditTextActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(CustomEditTextActivity::class.java)

    @Test
    fun givenInitialState_whenOpen_shouldCheckAllFields() {
        assertRobot {
            textFieldWithText("")
            textFieldWithHint("Text")
            textFieldWithError("")
            textFieldIsRequired(false)
            checkBoxTextRequiredIsChecked(false)

            numberFieldWithText("")
            numberFieldWithHint("Number")
            numberFieldWithError("")
            numberFieldIsRequired(false)
            checkBoxNumberRequiredIsChecked(false)

            moneyFieldWithText("")
            moneyFieldWithHint("Money")
            moneyFieldWithError("")
            moneyFieldIsRequired(false)
            checkBoxMoneyRequiredIsChecked(false)

            phoneFieldWithText("")
            phoneFieldWithHint("Phone")
            phoneFieldWithError("")
            phoneFieldIsRequired(false)
            checkBoxPhoneRequiredIsChecked(false)

            cpfFieldWithText("")
            cpfFieldWithHint("CPF")
            cpfFieldWithError("")
            cpfFieldIsRequired(false)
            checkBoxCPFRequiredIsChecked(false)

            cnpjFieldWithText("")
            cnpjFieldWithHint("CNPJ")
            cnpjFieldWithError("")
            cnpjFieldIsRequired(false)
            checkBoxCNPJRequiredIsChecked(false)

            validateButtonWithText("Validar")
            validateButtonIsEnabled(true)
            validateButtonIsLoading(false)
        }
    }

    @Test
    fun givenTextFieldEmptyAndRequired_whenValidate_shouldCheckErrorMessageForRequiredField() {
        actionRobot {
            fillTextField("")
            clickCheckBoxTextRequired()
            clickValidate()
        }
        assertRobot {
            textFieldWithText("")
            textFieldWithHint("Text*")
            textFieldWithError("O campo Text é obrigatório!")
            textFieldIsRequired(true)
            checkBoxTextRequiredIsChecked(true)
        }
    }

    @Test
    fun givenTextFieldIsNotEmptyAndRequired_whenValidate_shouldCheckErrorMessageIsEmpty() {
        actionRobot {
            fillTextField("test")
            clickCheckBoxTextRequired()
            clickValidate()
        }
        assertRobot {
            textFieldWithText("test")
            textFieldWithHint("Text*")
            textFieldWithError("")
            textFieldIsRequired(true)
            checkBoxTextRequiredIsChecked(true)
        }
    }

    @Test
    fun givenNumberFieldEmptyAndRequired_whenValidate_shouldCheckErrorMessageForRequiredField() {
        actionRobot {
            fillNumberField("")
            clickCheckBoxNumberRequired()
            clickValidate()
        }
        assertRobot {
            numberFieldWithText("")
            numberFieldWithHint("Number*")
            numberFieldWithError("O campo Number é obrigatório!")
            numberFieldIsRequired(true)
            checkBoxNumberRequiredIsChecked(true)
        }
    }

    @Test
    fun givenNumberFieldIsNotEmptyAndRequired_whenValidate_shouldCheckErrorMessageIsEmpty() {
        actionRobot {
            fillNumberField("999999")
            clickCheckBoxNumberRequired()
            clickValidate()
        }
        assertRobot {
            numberFieldWithText("999999")
            numberFieldWithHint("Number*")
            numberFieldWithError("")
            numberFieldIsRequired(true)
            checkBoxNumberRequiredIsChecked(true)
        }
    }

    @Test
    fun givenMoneyFieldEmptyAndRequired_whenValidate_shouldCheckErrorMessageForRequiredField() {
        actionRobot {
            clickCheckBoxMoneyRequired()
            clickValidate()
        }
        assertRobot {
            moneyFieldWithText("")
            moneyFieldWithHint("Money*")
            moneyFieldWithError("O campo Money é obrigatório!")
            moneyFieldIsRequired(true)
            checkBoxMoneyRequiredIsChecked(true)
        }
    }

    @Test
    fun givenMoneyFieldIsNotEmptyAndRequired_whenValidate_shouldCheckErrorMessageIsEmpty() {
        actionRobot {
            fillMoneyField("999999999")
            clickCheckBoxMoneyRequired()
            clickValidate()
        }
        assertRobot {
            moneyFieldWithText("R$ 9.999.999,99")
            moneyFieldWithHint("Money*")
            moneyFieldWithError("")
            moneyFieldIsRequired(true)
            checkBoxMoneyRequiredIsChecked(true)
        }
    }

    @Test
    fun givenPhoneFieldEmptyAndRequired_whenValidate_shouldCheckErrorMessageForRequiredField() {
        actionRobot {
            fillPhoneField("")
            clickCheckBoxPhoneRequired()
            clickValidate()
        }
        assertRobot {
            phoneFieldWithText("")
            phoneFieldWithHint("Phone*")
            phoneFieldWithError("O campo Phone é obrigatório!")
            phoneFieldIsRequired(true)
            checkBoxPhoneRequiredIsChecked(true)
        }
    }

    @Test
    fun givenPhoneFieldIsValid_whenValidate_shouldCheckErrorMessageIsEmpty() {
        actionRobot {
            fillPhoneField("99999999999")
            clickValidate()
        }
        assertRobot {
            phoneFieldWithText("(99) 99999-9999")
            phoneFieldWithHint("Phone")
            phoneFieldWithError("")
            phoneFieldIsRequired(false)
            checkBoxPhoneRequiredIsChecked(false)
        }
    }

    @Test
    fun givenPhoneFieldIsInvalid_whenValidate_shouldCheckErrorMessageForInvalidField() {
        actionRobot {
            fillPhoneField("999999999")
            clickValidate()
        }
        assertRobot {
            phoneFieldWithText("(99) 99999-99")
            phoneFieldWithHint("Phone")
            phoneFieldWithError("O valor do campo Phone, não é válido!")
            phoneFieldIsRequired(false)
            checkBoxPhoneRequiredIsChecked(false)
        }
    }

    @Test
    fun givenCPFFieldEmptyAndRequired_whenValidate_shouldCheckErrorMessageForRequiredField() {
        actionRobot {
            fillCPFField("")
            clickCheckBoxCPFRequired()
            clickValidate()
        }
        assertRobot {
            cpfFieldWithText("")
            cpfFieldWithHint("CPF*")
            cpfFieldWithError("O campo CPF é obrigatório!")
            cpfFieldIsRequired(true)
            checkBoxCPFRequiredIsChecked(true)
        }
    }

    @Test
    fun givenCPFFieldIsValid_whenValidate_shouldCheckErrorMessageIsEmpty() {
        actionRobot {
            fillCPFField("94985499072")
            clickValidate()
        }
        assertRobot {
            cpfFieldWithText("949.854.990-72")
            cpfFieldWithHint("CPF")
            cpfFieldWithError("")
            cpfFieldIsRequired(false)
            checkBoxCPFRequiredIsChecked(false)
        }
    }

    @Test
    fun givenCPFFieldIsInvalid_whenValidate_shouldCheckErrorMessageForInvalidField() {
        actionRobot {
            fillCPFField("99999999999")
            clickValidate()
        }
        assertRobot {
            cpfFieldWithText("999.999.999-99")
            cpfFieldWithHint("CPF")
            cpfFieldWithError("O valor do campo CPF, não é válido!")
            cpfFieldIsRequired(false)
            checkBoxCPFRequiredIsChecked(false)
        }
    }

    @Test
    fun givenCNPJFieldEmptyAndRequired_whenValidate_shouldCheckErrorMessageForRequiredField() {
        actionRobot {
            fillCNPJField("")
            clickCheckBoxCNPJRequired()
            clickValidate()
        }
        assertRobot {
            cnpjFieldWithText("")
            cnpjFieldWithHint("CNPJ*")
            cnpjFieldWithError("O campo CNPJ é obrigatório!")
            cnpjFieldIsRequired(true)
            checkBoxCNPJRequiredIsChecked(true)
        }
    }

    @Test
    fun givenCNPJFieldIsValid_whenValidate_shouldCheckErrorMessageIsEmpty() {
        actionRobot {
            fillCNPJField("45653624000146")
            clickValidate()
        }
        assertRobot {
            cnpjFieldWithText("45.653.624/0001-46")
            cnpjFieldWithHint("CNPJ")
            cnpjFieldWithError("")
            cnpjFieldIsRequired(false)
            checkBoxCNPJRequiredIsChecked(false)
        }
    }

    @Test
    fun givenCNPJFieldIsInvalid_whenValidate_shouldCheckErrorMessageForInvalidField() {
        actionRobot {
            fillCNPJField("99999999999999")
            clickValidate()
        }
        assertRobot {
            cnpjFieldWithText("99.999.999/9999-99")
            cnpjFieldWithHint("CNPJ")
            cnpjFieldWithError("O valor do campo CNPJ, não é válido!")
            cnpjFieldIsRequired(false)
            checkBoxCNPJRequiredIsChecked(false)
        }
    }
}