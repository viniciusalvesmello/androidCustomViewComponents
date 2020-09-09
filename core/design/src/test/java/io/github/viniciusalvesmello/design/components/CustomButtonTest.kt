package io.github.viniciusalvesmello.design.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import io.github.viniciusalvesmello.design.R
import io.github.viniciusalvesmello.design.components.button.CustomButton
import io.github.viniciusalvesmello.design.components.button.CustomButton.Companion.CUSTOM_BUTTON_DESCRIPTION_WHATSAPP
import io.github.viniciusalvesmello.design.components.button.CustomButton.Companion.CUSTOM_BUTTON_TYPE_DEFAULT
import io.github.viniciusalvesmello.design.components.button.CustomButton.Companion.CUSTOM_BUTTON_TYPE_PHONE
import io.github.viniciusalvesmello.design.components.button.CustomButton.Companion.CUSTOM_BUTTON_TYPE_WHATSAPP
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.spyk
import io.mockk.unmockkStatic
import io.mockk.verifySequence
import kotlinx.android.synthetic.main.custom_button.view.*
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CustomButtonTest {

    @MockK
    private lateinit var context: Context

    @MockK
    private lateinit var layoutInflater: LayoutInflater

    @MockK
    private lateinit var pbCustomButton: ProgressBar

    @MockK
    private lateinit var ivCustomButton: AppCompatImageView

    @MockK
    private lateinit var tvCustomButton: AppCompatTextView

    private lateinit var customButton: CustomButton
    private var iconWhatsApp: Drawable? = null
    private var iconPhone: Drawable? = null
    private var customButtonIsEnabled: Boolean = true

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)

        every { LayoutInflater.from(context) } returns layoutInflater
        every { layoutInflater.inflate(any<Int>(), any()) } returns mockk()

        customButton = spyk(CustomButton(context = context, autoInitializer = false))

        every { customButton.context } returns context
        every { customButton.pbCustomButton } returns pbCustomButton
        every { customButton.ivCustomButton } returns ivCustomButton
        every { customButton.tvCustomButton } returns tvCustomButton
        every { customButton.isEnabled } returns customButtonIsEnabled

        iconWhatsApp = ContextCompat.getDrawable(context, R.drawable.ic_whatsapp)
        iconPhone = ContextCompat.getDrawable(context, R.drawable.ic_phone)
    }

    @Test
    fun `given default button without icon When create Should check sequence create view`() {
        initializer("Test")

        verifySequence {
            tvCustomButton.text = "Test"
            ivCustomButton.setImageDrawable(null)
            ivCustomButton.visibility = View.GONE
            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given default button without icon initialized with loading When create Should check sequence create view`() {
        initializer("Test", isLoading = true)

        verifySequence {
            tvCustomButton.text = "Test"
            ivCustomButton.setImageDrawable(null)
            ivCustomButton.visibility = View.GONE
            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.GONE
            pbCustomButton.visibility = View.VISIBLE
        }
    }

    @Test
    fun `given default button without When create and after show and hide loading Should check sequence create and change view`() {
        initializer("Test")

        customButton.isLoading = true

        customButton.isLoading = false

        verifySequence {
            tvCustomButton.text = "Test"
            ivCustomButton.setImageDrawable(null)
            ivCustomButton.visibility = View.GONE
            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE

            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.GONE
            pbCustomButton.visibility = View.VISIBLE

            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given button WhatsApp When create Should check sequence create view`() {
        initializer(type = CUSTOM_BUTTON_TYPE_WHATSAPP)

        verifySequence {
            tvCustomButton.text = ""
            ivCustomButton.setImageDrawable(iconWhatsApp)
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.text = "WhatsApp"
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given button WhatsApp initialized with text When create Should check sequence create view`() {
        initializer(text = "(99) 99999-9999", type = CUSTOM_BUTTON_TYPE_WHATSAPP)

        verifySequence {
            tvCustomButton.text = "(99) 99999-9999"
            ivCustomButton.setImageDrawable(iconWhatsApp)
            ivCustomButton.visibility = View.VISIBLE
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given button WhatsApp initialized with loading When create Should check sequence create view`() {
        initializer(type = CUSTOM_BUTTON_TYPE_WHATSAPP, isLoading = true)

        verifySequence {
            tvCustomButton.text = ""
            ivCustomButton.setImageDrawable(iconWhatsApp)
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.text = "WhatsApp"
            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.GONE
            pbCustomButton.visibility = View.VISIBLE
        }
    }

    @Test
    fun `given button WhatsApp When create and after show and hide loading Should check sequence create and change view`() {
        initializer(type = CUSTOM_BUTTON_TYPE_WHATSAPP)

        customButton.isLoading = true

        customButton.isLoading = false

        verifySequence {
            tvCustomButton.text = ""
            ivCustomButton.setImageDrawable(iconWhatsApp)
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.text = "WhatsApp"
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE

            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.GONE
            pbCustomButton.visibility = View.VISIBLE

            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given button phone When create Should check sequence create view`() {
        initializer(type = CUSTOM_BUTTON_TYPE_PHONE)

        verifySequence {
            tvCustomButton.text = ""
            ivCustomButton.setImageDrawable(iconPhone)
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.text = "Telefone"
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given button phone initialized with text When create Should check sequence create view`() {
        initializer(text = "(99) 99999-9999", type = CUSTOM_BUTTON_TYPE_WHATSAPP)

        verifySequence {
            tvCustomButton.text = "(99) 99999-9999"
            ivCustomButton.setImageDrawable(iconWhatsApp)
            ivCustomButton.visibility = View.VISIBLE
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    @Test
    fun `given button phone initialized with loading When create Should check sequence create view`() {
        initializer(type = CUSTOM_BUTTON_TYPE_PHONE, isLoading = true)

        verifySequence {
            tvCustomButton.text = ""
            ivCustomButton.setImageDrawable(iconPhone)
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.text = "Telefone"
            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.GONE
            pbCustomButton.visibility = View.VISIBLE
        }
    }

    @Test
    fun `given button phone When create and after show and hide loading Should check sequence create and change view`() {
        initializer(type = CUSTOM_BUTTON_TYPE_PHONE)

        customButton.isLoading = true

        customButton.isLoading = false

        verifySequence {
            tvCustomButton.text = ""
            ivCustomButton.setImageDrawable(iconPhone)
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.text = "Telefone"
            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE

            ivCustomButton.visibility = View.GONE
            tvCustomButton.visibility = View.GONE
            pbCustomButton.visibility = View.VISIBLE

            ivCustomButton.visibility = View.VISIBLE
            tvCustomButton.visibility = View.VISIBLE
            pbCustomButton.visibility = View.GONE
        }
    }

    private fun initializer(
        text: String = "",
        type: Int = CUSTOM_BUTTON_TYPE_DEFAULT,
        drawable: Drawable? = null,
        isEnabled: Boolean = true,
        isLoading: Boolean = false
    ) {
        customButton.text = text
        when (type) {
            CUSTOM_BUTTON_TYPE_DEFAULT -> {
                customButton.drawable = drawable
            }
            CUSTOM_BUTTON_TYPE_WHATSAPP -> {
                customButton.drawable = ContextCompat.getDrawable(context, R.drawable.ic_whatsapp)
                if (customButton.text.isEmpty()) {
                    customButton.text = CUSTOM_BUTTON_DESCRIPTION_WHATSAPP
                }
            }
            CUSTOM_BUTTON_TYPE_PHONE -> {
                customButton.drawable = ContextCompat.getDrawable(context, R.drawable.ic_phone)
                if (customButton.text.isEmpty()) {
                    customButton.text = CustomButton.CUSTOM_BUTTON_DESCRIPTION_PHONE
                }
            }
        }
        customButtonIsEnabled = isEnabled
        customButton.isLoading = isLoading
    }

    companion object {
        @JvmStatic
        @BeforeClass
        fun setUpClass() {
            mockkStatic(LayoutInflater::class)
        }

        @JvmStatic
        @AfterClass
        fun tearDownClass() {
            unmockkStatic(LayoutInflater::class)
        }
    }
}