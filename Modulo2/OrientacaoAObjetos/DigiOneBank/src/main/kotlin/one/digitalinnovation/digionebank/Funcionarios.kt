package one.digitalinnovation.digionebank

class Analista(
    nome: String,
    cpf: String,
    salario: Double)
    : Funcionario(nome, cpf, salario) {
    override fun calculoAuxilio(): Double = salario.times(0.1)
}

class Gerente(
    nome: String,
    cpf: String,
    salario: Double)
    : Funcionario(nome, cpf, salario) {
    override fun calculoAuxilio() = salario.times(0.4)

}
fun main(){
    val joao = Analista("Joao Perdor", "1235454768", 2000.0)
    val maria = Gerente("Maria Maria", "8764312345", 5000.0)

    Relatorio.imprimir(maria)
}
