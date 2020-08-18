package io.github.viniciusalvesmello.design.components.edittext

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import io.github.viniciusalvesmello.design.R
import io.github.viniciusalvesmello.design.components.edittext.type.CPFType
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextType
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.CNPJ
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.CPF
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.MONEY
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.NUMBER
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.PHONE
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.RG
import io.github.viniciusalvesmello.design.components.edittext.type.EditTextTypeConstants.TEXT
import io.github.viniciusalvesmello.design.components.edittext.type.GeneralType
import io.github.viniciusalvesmello.design.components.edittext.type.MoneyType

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(
            context,
            R.layout.custom_edittext, this
        )

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomEditTextStyleable,
            defStyleAttr,
            defStyleRes
        ).apply {


            recycle()
        }
    }

    private fun Int.getEditTextType(): EditTextType = when (this) {
        TEXT -> GeneralType()
        NUMBER -> GeneralType()
        MONEY -> MoneyType()
        PHONE -> GeneralType()
        CPF -> CPFType()
        CNPJ -> MoneyType()
        RG -> GeneralType()
        else -> GeneralType()
    }
}