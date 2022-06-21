package one.digitalinnovation.digionebank

class Pessoa {
    val nome: String = "Jether"
    var cpf: String = "123.123.123-11"
    private set

    inner class Endereco {
        var rua: String = "Rua teste"
    }

    constructor()

    override fun toString(): String {
        return "$nome e $cpf"
    }
}
