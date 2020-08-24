package io.github.viniciusalvesmello.design.components.card.contact

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import io.github.viniciusalvesmello.design.R
import io.github.viniciusalvesmello.design.extension.handle
import io.github.viniciusalvesmello.design.extension.isDebuggable
import kotlinx.android.synthetic.main.custom_contact_card.view.*

class CustomContactCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var data: CustomContactCardModel? = null

    var contact: CustomContactCardModel
        get() = data ?: CustomContactCardModel.empty()
        set(value) {
            data = value.apply {
                tvName.text = name
                tvPhone.text = phone
                tvCPF.text = cpf
            }
        }

    init {
        inflate(
            context,
            R.layout.custom_contact_card, this
        )

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomContactCardStyleable,
            defStyleAttr,
            defStyleRes
        ).apply {

            initBackground(this)

            initTitleTextColor(this)
            initTitleFont(this)
            initTitleTextStyle(this)
            initTitleTextSize(this)

            initValuesTextColor(this)
            initValuesFont(this)
            initValuesTextStyle(this)
            initValuesTextSize(this)
            initValues(this)

            isEnabled = true

            recycle()
        }
    }

    private fun initBackground(typedArray: TypedArray) {
        typedArray.getDrawable(R.styleable.CustomContactCardStyleable_android_background)?.apply {
            background = this
        }
    }

    private fun initTitleTextColor(typedArray: TypedArray) {
        val color = typedArray.getColor(
            R.styleable.CustomContactCardStyleable_customContactCardTitleTextColor,
            0
        )
        tvNameTitle.setTextColor(color)
        tvPhoneTitle.setTextColor(color)
        tvCPFTitle.setTextColor(color)
    }


    private fun initTitleFont(typedArray: TypedArray) {
        if (!isInEditMode) {
            try {
                val font = ResourcesCompat.getFont(
                    context,
                    typedArray.getResourceId(
                        R.styleable.CustomContactCardStyleable_customContactCardTitleFontFamily,
                        -1
                    )
                )
                tvNameTitle.typeface = font
                tvPhoneTitle.typeface = font
                tvCPFTitle.typeface = font
            } catch (t: Resources.NotFoundException) {
                t.isDebuggable(context) {
                    Log.d(TAG_ERROR, "$PREFIX_MESSAGE_ERROR ${it.message.toString()}")
                }
            }
        }
    }

    private fun initTitleTextStyle(typedArray: TypedArray) {
        val style = typedArray.getInt(
            R.styleable.CustomContactCardStyleable_customContactCardTitleTextStyle,
            0
        )
        tvNameTitle.setTypeface(tvNameTitle.typeface, style)
        tvPhoneTitle.setTypeface(tvNameTitle.typeface, style)
        tvCPFTitle.setTypeface(tvNameTitle.typeface, style)
    }

    private fun initTitleTextSize(typedArray: TypedArray) {
        val textSize = typedArray.getDimensionPixelSize(
            R.styleable.CustomContactCardStyleable_customContactCardTitleTextSize,
            0
        ).toFloat()
        tvNameTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        tvPhoneTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        tvCPFTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
    }

    private fun initValuesTextColor(typedArray: TypedArray) {
        val color = typedArray.getColor(
            R.styleable.CustomContactCardStyleable_customContactCardTextColor,
            0
        )
        tvName.setTextColor(color)
        tvPhone.setTextColor(color)
        tvCPF.setTextColor(color)
    }

    private fun initValuesFont(typedArray: TypedArray) {
        if (!isInEditMode) {
            try {
                val font = ResourcesCompat.getFont(
                    context,
                    typedArray.getResourceId(
                        R.styleable.CustomContactCardStyleable_customContactCardFontFamily,
                        -1
                    )
                )
                tvName.typeface = font
                tvPhone.typeface = font
                tvCPF.typeface = font
            } catch (t: Resources.NotFoundException) {
                t.isDebuggable(context) {
                    Log.d(TAG_ERROR, "$PREFIX_MESSAGE_ERROR ${it.message.toString()}")
                }
            }
        }
    }

    private fun initValuesTextStyle(typedArray: TypedArray) {
        val style = typedArray.getInt(
            R.styleable.CustomContactCardStyleable_customContactCardTextStyle,
            0
        )
        tvName.setTypeface(tvNameTitle.typeface, style)
        tvPhone.setTypeface(tvNameTitle.typeface, style)
        tvCPF.setTypeface(tvNameTitle.typeface, style)
    }

    private fun initValuesTextSize(typedArray: TypedArray) {
        val textSize = typedArray.getDimensionPixelSize(
            R.styleable.CustomContactCardStyleable_customContactCardTextSize,
            0
        ).toFloat()
        tvNameTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        tvPhoneTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        tvCPFTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
    }

    private fun initValues(typedArray: TypedArray) = with(typedArray) {
        contact = CustomContactCardModel(
            name = getString(R.styleable.CustomContactCardStyleable_customContactCardNome).handle(),
            phone = getString(R.styleable.CustomContactCardStyleable_customContactCardPhone).handle(),
            cpf = getString(R.styleable.CustomContactCardStyleable_customContactCardCPF).handle()
        )
    }

    fun onCustomContactCardClickListener(
        func: (view: View?, customContactCardModel: CustomContactCardModel) -> Unit
    ) {
        setOnClickListener { func(it, contact) }
    }

    companion object {
        private const val TAG_ERROR = "error_custom_button"
        private const val PREFIX_MESSAGE_ERROR = "Error set font family on CustomContactCard:"
    }
}