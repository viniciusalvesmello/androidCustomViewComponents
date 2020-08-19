package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType

class NumberType: EditTextType() {

    override fun getInputType(): Int = InputType.TYPE_CLASS_NUMBER
}