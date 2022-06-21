package one.digitalinnovation.digionebank

class Pessoa {
    val nome: String = "Jether"
    var cpf: String = "123.123.123-11"

}

fun main(){
    val p = Pessoa()

    println("Nome: ${p.nome}; cpf: ${p.cpf}")
}