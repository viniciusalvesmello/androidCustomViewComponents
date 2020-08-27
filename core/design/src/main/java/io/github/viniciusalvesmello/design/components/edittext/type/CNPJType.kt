package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType
import android.text.TextWatcher
import br.com.concrete.canarinho.formatador.Formatador
import br.com.concrete.canarinho.validator.Validador
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher

class CNPJType : EditTextType() {

    override fun getInputType(): Int = InputType.TYPE_CLASS_NUMBER

    override fun getTextWatcher(): TextWatcher =
        MascaraNumericaTextWatcher.Builder().apply {
            paraMascara(MASK_CNPJ)
        }.build()

    override fun getTextWithoutMask(text: String): String =
        Formatador.CNPJ.desformata(text)

    override fun isValid(text: String, required: Boolean): Boolean = when {
        !required && text.isEmpty() -> true
        required && getTextWithoutMask(text).isEmpty() -> false
        else -> Validador.CNPJ.ehValido(text)
    }

    companion object {
        private const val MASK_CNPJ = "##.###.###/####-##"
    }
}