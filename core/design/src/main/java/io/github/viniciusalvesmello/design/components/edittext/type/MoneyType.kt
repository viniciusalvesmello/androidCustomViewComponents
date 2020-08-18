package io.github.viniciusalvesmello.design.components.edittext.type

import android.text.InputType
import android.text.TextWatcher
import br.com.concrete.canarinho.formatador.Formatador
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

class MoneyType : EditTextType() {

    override fun getInputType(): Int = InputType.TYPE_CLASS_NUMBER

    override fun getTextWatcher(): TextWatcher =
        ValorMonetarioWatcher.Builder().apply {
            comSimboloReal()
            comMantemZerosAoLimpar()
        }.build()

    override fun String.getTextWithoutMask(): String =
        Formatador.VALOR_COM_SIMBOLO.desformata(this).trim()
}