package one.digitalinnovation.collections

fun main(){
    val joao = Funcionario("Joao", 9880.0, "CLT")
    val maria = Funcionario("Maria", 3040.0, "CLT")
    val pedro = Funcionario("Pedro", 4000.0, "Pj")

    val funcionarios1 = setOf(joao, pedro)
    val funcionarios2 = setOf(maria)

    val funcUnion = funcionarios1.union(funcionarios2)
    funcUnion.forEach{println(it)}

    println("==================")
    val funcionarios3 = setOf(joao, pedro, maria)
    val funcSubtract = funcionarios3.subtract(funcionarios2)
    funcSubtract.forEach{println(it)}

    println("==================")
    val funcIntersect =  funcionarios3.intersect(funcionarios2)
    funcIntersect.forEach { println(it) }

}