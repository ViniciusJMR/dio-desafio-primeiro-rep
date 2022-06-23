package one.digitalinnovation.collections

fun main(){
    val salarios = doubleArrayOf(1000.0, 3000.0, 500.0)

    salarios.forEachIndexed { index, salario ->
        salarios[index] = salario.times(1.1)
    }

    salarios.forEach{ println(it) }

}
