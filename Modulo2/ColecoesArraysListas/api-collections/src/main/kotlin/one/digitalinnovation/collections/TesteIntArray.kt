package one.digitalinnovation.collections

fun main(){
    val values = intArrayOf(1, 3, 5, 2,6)

    for (valor in values)
        println(valor)

    values.forEach {
        println(it)
    }

    for(index in values.indices)
        println(values[index])
}
