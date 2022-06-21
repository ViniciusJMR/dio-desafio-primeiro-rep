package one.digitalinnovation.digionebank

data class Banco(
    val nome: String,
    val numero: Int
){

    override fun toString(): String {
        return "$nome - $numero"
    }
}