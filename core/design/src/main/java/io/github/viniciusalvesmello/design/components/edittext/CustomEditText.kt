package io.github.viniciusalvesmello.design.components.edittext

import android.content.Context
import android.text.InputFilter
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
import io.github.viniciusalvesmello.design.components.edittext.type.MoneyType
import io.github.viniciusalvesmello.design.components.edittext.type.NumberType
import io.github.viniciusalvesmello.design.components.edittext.type.PhoneType
import io.github.viniciusalvesmello.design.components.edittext.type.TextType
import io.github.viniciusalvesmello.design.extension.handle
import kotlinx.android.synthetic.main.custom_edittext.view.*

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var text: String
        get() = tietCustomEditText.text.toString()
        set(value) {
            tietCustomEditText.setText(value)
        }

    var hint: String
        get() = tilCustomEditText.hint.toString()
        set(value) {
            tilCustomEditText.hint = value
        }

    var error: String
        get() = tilCustomEditText.error.toString()
        set(value) {
            tilCustomEditText.error = value
        }

    var required: Boolean = false

    private var editTextType: EditTextType = TextType()

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

            text = getString(R.styleable.CustomEditTextStyleable_android_text).handle()
            hint = getString(R.styleable.CustomEditTextStyleable_android_hint).handle()
            required = getBoolean(R.styleable.CustomEditTextStyleable_android_required, false)
            setCustomEditTextType(getInt(R.styleable.CustomEditTextStyleable_customEditTextType, 0))
            setMaxLength(getInt(R.styleable.CustomEditTextStyleable_android_maxLength, 0))

            recycle()
        }
    }

    fun setCustomEditTextType(type: Int) {
        editTextType = type.getEditTextType()
        editTextType.apply {
            tietCustomEditText.inputType = getInputType()
            getTextWatcher()?.let { tietCustomEditText.addTextChangedListener(it) }
        }
    }

    fun setMaxLength(length: Int) {
        if(length <= 0) return
        tietCustomEditText.filters = arrayOf(InputFilter.LengthFilter(length))
    }

    fun isValid() = editTextType.isValid(text, required)

    private fun Int.getEditTextType(): EditTextType = when (this) {
        TEXT -> TextType()
        NUMBER -> NumberType()
        MONEY -> MoneyType()
        PHONE -> PhoneType()
        CPF -> CPFType()
        CNPJ -> MoneyType()
        RG -> TextType()
        else -> TextType()
    }
}