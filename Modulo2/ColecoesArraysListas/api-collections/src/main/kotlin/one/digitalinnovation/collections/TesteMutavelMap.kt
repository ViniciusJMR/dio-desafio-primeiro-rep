package one.digitalinnovation.collections

fun main(){
    val joao = Funcionario("Joao", 9880.0, "CLT")
    val maria = Funcionario("Maria", 3040.0, "CLT")
    val pedro = Funcionario("Pedro", 4000.0, "Pj")

    val repositorio = Repositorio<Funcionario>()

    repositorio.create(joao.nome, joao)
    repositorio.create(maria.nome, maria)
    repositorio.create(pedro.nome, pedro)

    println(repositorio.findBy(joao.nome))

    println("=======================")
    repositorio.findAll().forEach { println(it) }

    println("=======================")
    repositorio.remove(maria.nome)
    repositorio.findAll().forEach { println(it) }
}