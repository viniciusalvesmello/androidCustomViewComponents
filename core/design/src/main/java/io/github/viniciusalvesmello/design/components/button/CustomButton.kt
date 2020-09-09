package io.github.viniciusalvesmello.design.components.button

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import io.github.viniciusalvesmello.design.R
import io.github.viniciusalvesmello.design.extension.gone
import io.github.viniciusalvesmello.design.extension.handle
import io.github.viniciusalvesmello.design.extension.isDebuggable
import io.github.viniciusalvesmello.design.extension.visible
import kotlinx.android.synthetic.main.custom_button.view.*

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
    autoInitializer: Boolean = true
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var _text: String = ""
    var text: String
        get() = _text
        set(value) {
            tvCustomButton.text = value
            _text = value
        }

    var isLoading: Boolean
        get() = pbCustomButton.visibility == View.VISIBLE
        set(value) {
            if (value && isEnabled) {
                updateStateView(false)
                ivCustomButton.gone()
                tvCustomButton.gone()
                pbCustomButton.visible()
            } else {
                updateStateView(isEnabled)
                drawable?.run { ivCustomButton.visible() } ?: ivCustomButton.gone()
                tvCustomButton.visible()
                pbCustomButton.gone()
            }
        }

    private var _drawable: Drawable? = null
    var drawable: Drawable?
        get() = _drawable
        set(value) {
            ivCustomButton.setImageDrawable(value)
            _drawable = value
            value?.run { ivCustomButton.visible() } ?: ivCustomButton.gone()
        }

    init {
        inflate(context, R.layout.custom_button, this)

        if (autoInitializer) {
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.CustomButtonStyleable,
                defStyleAttr,
                defStyleRes
            ).apply {
                initText(this)
                initIcon(this)
                initState(this)

                recycle()
            }
        }
    }

    private fun initText(typedArray: TypedArray) {
        text = typedArray.getString(R.styleable.CustomButtonStyleable_android_text).handle()

        tvCustomButton.setTextColor(getTextColor(typedArray))

        if (!isInEditMode) {
            try {
                tvCustomButton.typeface = ResourcesCompat.getFont(
                    context,
                    typedArray.getResourceId(
                        R.styleable.CustomButtonStyleable_android_fontFamily,
                        -1
                    )
                )
            } catch (t: Resources.NotFoundException) {
                t.isDebuggable(context) {
                    Log.d(
                        CUSTOM_BUTTON_TAG_ERROR,
                        "$CUSTOM_BUTTON_PREFIX_MESSAGE_ERROR ${it.message.toString()}"
                    )
                }
            }
        }

        tvCustomButton.setTextSize(
            TypedValue.COMPLEX_UNIT_PX,
            typedArray.getDimensionPixelSize(
                R.styleable.CustomButtonStyleable_android_textSize,
                0
            ).toFloat()
        )
    }

    private fun initIcon(typedArray: TypedArray) = with(typedArray) {
        val type = getInt(
            R.styleable.CustomButtonStyleable_customButtonType,
            CUSTOM_BUTTON_TYPE_DEFAULT
        )

        when (type) {
            CUSTOM_BUTTON_TYPE_DEFAULT -> {
                drawable = getDrawable(R.styleable.CustomButtonStyleable_customButtonIcon)
            }
            CUSTOM_BUTTON_TYPE_WHATSAPP -> {
                drawable = ContextCompat.getDrawable(context, R.drawable.ic_whatsapp)
                if (text.isEmpty()) {
                    text = CUSTOM_BUTTON_DESCRIPTION_WHATSAPP
                }
            }
            CUSTOM_BUTTON_TYPE_PHONE -> {
                drawable = ContextCompat.getDrawable(context, R.drawable.ic_phone)
                if (text.isEmpty()) {
                    text = CUSTOM_BUTTON_DESCRIPTION_PHONE
                }
            }
        }
    }

    private fun initState(typedArray: TypedArray) {
        isEnabled = typedArray.getBoolean(
            R.styleable.CustomButtonStyleable_android_enabled,
            true
        )

        isLoading = typedArray.getBoolean(
            R.styleable.CustomButtonStyleable_customButtonIsLoading,
            false
        )

        pbCustomButton.indeterminateTintList = getTextColor(typedArray)
    }

    private fun getTextColor(typedArray: TypedArray) = ColorStateList(
        arrayOf(
            intArrayOf(android.R.attr.state_enabled),
            intArrayOf(-android.R.attr.state_enabled)
        ),
        intArrayOf(
            typedArray.getColor(
                R.styleable.CustomButtonStyleable_android_textColor,
                0
            ),
            typedArray.getColor(
                R.styleable.CustomButtonStyleable_customButtonDisabledTextColor,
                0
            )
        )
    )

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        updateStateView(enabled)
    }

    private fun updateStateView(isEnabled: Boolean) {
        isClickable = isEnabled
        isFocusable = isEnabled
    }

    companion object {
        const val CUSTOM_BUTTON_TYPE_DEFAULT = 0
        const val CUSTOM_BUTTON_TYPE_WHATSAPP = 1
        const val CUSTOM_BUTTON_TYPE_PHONE = 2
        const val CUSTOM_BUTTON_DESCRIPTION_WHATSAPP = "WhatsApp"
        const val CUSTOM_BUTTON_DESCRIPTION_PHONE = "Telefone"

        private const val CUSTOM_BUTTON_TAG_ERROR = "error_custom_button"
        private const val CUSTOM_BUTTON_PREFIX_MESSAGE_ERROR = "Error set font family on CustomButton:"
    }
}