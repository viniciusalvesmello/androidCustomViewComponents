package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType
import android.text.TextWatcher
import br.com.concrete.canarinho.formatador.Formatador
import br.com.concrete.canarinho.validator.Validador
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher

class CPFType : EditTextType() {

    override fun getInputType(): Int = InputType.TYPE_CLASS_NUMBER

    override fun getTextWatcher(): TextWatcher =
        MascaraNumericaTextWatcher.Builder().apply {
            paraMascara(MASK_CPF)
        }.build()

    override fun getTextWithoutMask(text: String): String =
        Formatador.CPF.desformata(text)

    override fun isValid(text: String, required: Boolean): Boolean = when {
        !required && text.isEmpty() -> true
        required && getTextWithoutMask(text).isEmpty() -> false
        else -> Validador.CPF.ehValido(text)
    }

    companion object {
        private const val MASK_CPF = "###.###.###-##"
    }
}