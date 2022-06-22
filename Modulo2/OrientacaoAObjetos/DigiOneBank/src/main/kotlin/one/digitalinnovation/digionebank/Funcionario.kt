package one.digitalinnovation.digionebank

import java.math.BigDecimal

abstract class Funcionario(
    nome: String,
    cpf: String,
    var salario: Double) : Pessoa(nome, cpf){
        protected abstract fun calculoAuxilio(): Double

    override fun toString() = """
        Nome: $nome
        Cpf: $cpf
        Salario: $salario
        Calculo Auxilio: ${calculoAuxilio()}
    """.trimIndent()
}
