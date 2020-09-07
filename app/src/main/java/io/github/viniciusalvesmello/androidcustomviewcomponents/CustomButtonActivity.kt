package io.github.viniciusalvesmello.androidcustomviewcomponents

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.viniciusalvesmello.design.components.button.CustomButton
import kotlinx.android.synthetic.main.activity_custom_button.*

class CustomButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_button)

        initListeners()
    }

    private fun initListeners() {
        cbPrimaryEnabled.showText()
        cbPrimaryDisabled.showText()
        cbTypeWhatsAppEnabled.showText()
        cbTypeWhatsAppDisabled.showText()
        cbTypeWhatsAppWithPhone.showText()
        cbTypePhoneEnabled.showText()
        cbTypePhoneDisabled.showText()
        cbTypePhoneWithNumber.showText()
    }

    private fun CustomButton.showText() {
        setOnClickListener {
            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        }
    }
}