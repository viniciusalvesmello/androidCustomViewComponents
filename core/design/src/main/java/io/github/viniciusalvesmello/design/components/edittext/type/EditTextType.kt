package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType
import android.text.TextWatcher

abstract class EditTextType {
    open fun getInputType(): Int = InputType.TYPE_CLASS_TEXT

    open fun getTextWatcher(): TextWatcher? = null

    open fun String.getTextWithoutMask(): String = trim()

    open fun String.isValid(required: Boolean = true): Boolean = when {
        required && getTextWithoutMask().isEmpty() -> {
            false
        }
        else -> {
            true
        }
    }
}