package io.github.viniciusalvesmello.androidcustomviewcomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.viniciusalvesmello.design.extension.withError
import kotlinx.android.synthetic.main.activity_custom_edit_text.*

class CustomEditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_edit_text)

        initListener()
    }

    private fun initListener() {
        cbValidate.setOnClickListener {
            cetText.withError()
            cetNumber.withError()
            cetMoney.withError()
            cetPhone.withError()
            cetCPF.withError()
            cetCNPJ.withError()
        }

        mcbTextRequired.setOnCheckedChangeListener { _, isChecked ->
            cetText.required = isChecked
        }

        mcbNumberRequired.setOnCheckedChangeListener { _, isChecked ->
            cetNumber.required = isChecked
        }

        mcbMoneyRequired.setOnCheckedChangeListener { _, isChecked ->
            cetMoney.required = isChecked
        }

        mcbPhoneRequired.setOnCheckedChangeListener { _, isChecked ->
            cetPhone.required = isChecked
        }

        mcbCPFRequired.setOnCheckedChangeListener { _, isChecked ->
            cetCPF.required = isChecked
        }

        mcbCNPJRequired.setOnCheckedChangeListener { _, isChecked ->
            cetCNPJ.required = isChecked
        }
    }
}