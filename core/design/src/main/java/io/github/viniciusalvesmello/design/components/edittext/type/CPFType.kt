package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType
import android.text.TextWatcher
import br.com.concrete.canarinho.formatador.Formatador
import br.com.concrete.canarinho.validator.Validador
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher

class CPFType: EditTextType() {

    override fun getInputType(): Int = InputType.TYPE_CLASS_NUMBER

    override fun getTextWatcher(): TextWatcher =
        MascaraNumericaTextWatcher.Builder().apply {
            paraMascara(MASK_CPF)
        }.build()

    override fun String.getTextWithoutMask(): String =
        Formatador.CPF.desformata(this)

    override fun String.isValid(required: Boolean): Boolean =
        Validador.CPF.ehValido(this)

    companion object {
        private const val MASK_CPF = "###.###.###-##"
    }
}