package io.github.viniciusalvesmello.design.extension

import io.github.viniciusalvesmello.design.components.edittext.CustomEditText

fun CustomEditText.withError(): Boolean = when {
    (required && text.isEmpty()) -> {
        error = "O campo $hint é obrigatório!"
        false
    }
    (!isValid()) -> {
        error = "O valor do campo $hint, não é válido!"
        false
    }
    else -> {
        clearError()
        true
    }
}