package one.digitalinnovation.collections

fun main(){
    val joao = Funcionario("Joao", 9880.0, "CLT")
    val maria = Funcionario("Maria", 3040.0, "CLT")
    val pedro = Funcionario("Pedro", 4000.0, "Pj")

    val funcionarios = arrayListOf(joao, pedro, maria)

    funcionarios.forEach{ println(it) }

    println("=================")
    println(funcionarios.find{it.nome == "Maria"})

    println("=================")
    funcionarios
        .sortedBy { it.salario }
        .forEach{ println(it) }

    println("=================")
    funcionarios
        .groupBy{it.tipo}
        .forEach{println(it)}

    funcionarios.sortBy { it.salario }
}
