// Abaixo segue um exemplo de código que você pode ou não utilizar

fun main() {

//TODO: Complete os espaços em branco com uma possível solução para o desafio

    val notas: IntArray = intArrayOf(100, 50, 20, 10, 5, 2, 1)
    var valor = readLine()!!.toInt()

    println(valor)

    for(nota in notas){
        if (valor >= nota){
            val qtdNotas = valor/nota
            println("$qtdNotas nota(s) de R$ $nota,00")
        }
        else
            println("0 nota(s) de R$ $nota,00")

        valor %= nota
    }
}