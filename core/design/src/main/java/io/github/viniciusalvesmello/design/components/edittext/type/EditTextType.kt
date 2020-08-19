package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType
import android.text.TextWatcher

abstract class EditTextType {

    open fun getInputType(): Int = InputType.TYPE_CLASS_TEXT

    open fun getTextWatcher(): TextWatcher? = null

    open fun getTextWithoutMask(text: String): String = text.trim()

    open fun isValid(text: String, required: Boolean = true): Boolean = when {
        required && getTextWithoutMask(text).isEmpty() -> {
            false
        }
        else -> {
            true
        }
    }
}