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
    salario: Double,
    val senha: String)
    : Funcionario(nome, cpf, salario), Logavel {
    override fun calculoAuxilio() = salario.times(0.4)

    override fun login() = senha == "1234"


}
fun main(){
    //Teste Autenticacao


}
