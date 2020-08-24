package io.github.viniciusalvesmello.design.components.card.contact

data class CustomContactCardModel(
    val name: String,
    val phone: String,
    val cpf: String
) {
    companion object {
        fun empty() = CustomContactCardModel("", "", "")
    }
}