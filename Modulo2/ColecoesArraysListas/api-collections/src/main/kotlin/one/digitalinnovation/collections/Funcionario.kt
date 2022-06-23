package one.digitalinnovation.collections

data class Funcionario(
    val nome: String,
    val salario: Double,
    val tipo: String
){
    override fun toString() = """
        Nome:       $nome
        salario:    $salario
    """.trimIndent()
}
