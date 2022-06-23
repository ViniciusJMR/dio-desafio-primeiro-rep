package one.digitalinnovation.collections

fun main(){
    val joao = Funcionario("Joao", 9880.0, "CLT")
    val maria = Funcionario("Maria", 3040.0, "CLT")
    val pedro = Funcionario("Pedro", 4000.0, "Pj")

    println("============ LIST ============")
    val funcionarios = mutableListOf(joao, maria)

    funcionarios.add(pedro)
    funcionarios.forEach { println(it) }

    println("======================")
    funcionarios.remove(joao)
    funcionarios.forEach { println(it) }

    println("========= SET ============")
    val funcSet = mutableSetOf(joao)
    funcSet.add(pedro)
    funcSet.add(maria)
    funcSet.add(maria)
    funcSet.forEach { println(it) }


}