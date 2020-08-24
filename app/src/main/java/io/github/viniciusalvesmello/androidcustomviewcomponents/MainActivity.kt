package io.github.viniciusalvesmello.androidcustomviewcomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.viniciusalvesmello.design.components.card.contact.CustomContactCard
import io.github.viniciusalvesmello.design.components.card.contact.CustomContactCardModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        cbInsert.setOnClickListener {
            addContact()
        }
    }

    private fun validName(): Boolean =
        if (cetNome.required && cetNome.text.isEmpty()) {
            cetNome.error = "O campo Nome é obrigatório!"
            false
        } else {
            cetNome.clearError()
            true
        }

    private fun validPhone(): Boolean = when {
        (cetPhone.required && cetPhone.text.isEmpty()) -> {
            cetPhone.error = "O campo Telephone é obrigatório!"
            false
        }
        (!cetPhone.isValid()) -> {
            cetPhone.error = "Telefone inválido!"
            false
        }
        else -> {
            cetPhone.clearError()
            true
        }
    }

    private fun validCPF(): Boolean = when {
        (cetCPF.required && cetCPF.text.isEmpty()) -> {
            cetCPF.error = "O campo CPF é obrigatório!"
            false
        }
        (!cetCPF.isValid()) -> {
            cetCPF.error = "CPF inválido!"
            false
        }
        else -> {
            cetCPF.clearError()
            true
        }
    }

    private fun contactIsValid(): Boolean {
        val name = validName()
        val phone = validPhone()
        val cpf = validCPF()

        return name && phone && cpf
    }

    private fun addContact() {
        if (contactIsValid()) {
            llContacts.addView(
                CustomContactCard(
                    context = this,
                    defStyleRes = R.style.CustomContactCard_Primary
                ).apply {
                    contact = CustomContactCardModel(
                        name = cetNome.text,
                        phone = cetPhone.text,
                        cpf = cetCPF.text
                    )
                }
            )
        }
    }
}