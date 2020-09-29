package io.github.viniciusalvesmello.androidcustomviewcomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.github.viniciusalvesmello.design.components.button.CustomButton
import kotlinx.android.synthetic.main.activity_custom_button.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CustomButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_button)

        initListeners()
    }

    private fun initListeners() {
        cbPrimaryEnabled.setAction()
        cbPrimaryDisabled.setAction()
        cbTypeWhatsAppEnabled.setAction()
        cbTypeWhatsAppDisabled.setAction()
        cbTypeWhatsAppWithPhone.setAction()
        cbTypePhoneEnabled.setAction()
        cbTypePhoneDisabled.setAction()
        cbTypePhoneWithNumber.setAction()
    }

    private fun CustomButton.setAction() {
        setOnClickListener { view ->
            (view as? CustomButton)?.apply {
                "Last Action: $text".let { text -> tvLastAction.text = text }
                runLoading()
            }
        }
    }

    private fun CustomButton.runLoading() {
        lifecycleScope.launch {
            isLoading = true
            delay(3000L)
            isLoading = false
        }
    }

}