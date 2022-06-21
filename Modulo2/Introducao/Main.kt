
fun main(){
    val name = "Maria Clara"

    name.forEach { println(it) }
}

fun whenFuction(){
    val x = readln().toInt()
    val a = 40
    val b = 2

    when {
        a*b == x -> {println("entrou 1")}
        a/b == x -> {println("entrou 2")}
        else -> {println("entrou else")}
    }

    when(a){
        in 0..100 -> println("UEEPAAAA")
    }

}

//Funções/extensões
//println("teestando aaa".randomCapitalizedLetter())
fun String.randomCapitalizedLetter() =
    this[(0..this.length).random()].uppercaseChar()

//Funções de ordem superior
/*
    z = calculate(34, 90){a,b ->
        (a+b)*2
    }
 */
fun sum(a:Int , b:Int) = a.plus(b)
fun calculate(n1: Int, n2: Int, operation:(Int,Int)->Int) = operation(n1, n2)

class range(){
    //Exemplo da utilização de Range
    var age = (10..100).random()
    fun start(){
        println(age)
        println(age in MIN_AGE..MAX_AGE)
        println(age >= MIN_AGE && age <= MAX_AGE)
    }

    companion object {
        const val MIN_AGE = 16
        const val MAX_AGE = 68
    }
}