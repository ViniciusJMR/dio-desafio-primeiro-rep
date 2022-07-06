package one.digitalinnovation.collections

fun main() {
    val nome = Array(3) {""}
    nome[0] = "Maria"
    nome[1] = "João"
    nome[2] = "Jose"

    for (n in nome){
        println(n)
    }

    println("=======================")
    nome.sort()
    nome.forEach { println(it) }

    val nomes2 = arrayOf("Maria", "Zazá", "Pedro")
    println("=======================")
    nomes2.sort()
    nomes2.forEach { println(it) }

}