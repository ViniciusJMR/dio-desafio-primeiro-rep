package one.digitalinnovation.digionebank

import java.math.BigDecimal

class Analista(
    nome: String,
    cpf: String,
    salario: Double)
    : Funcionario(nome, cpf, salario) {
    override fun calculoAuxilio(): Double = salario.times(0.1)
}

fun main(){
    val joao = Analista("Joao Perdor", "1235454768", 2000.0)
    imprimeRelatorio(joao)
}

fun imprimeRelatorio(f: Funcionario) = println(f.toString())