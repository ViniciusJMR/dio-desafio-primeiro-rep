package one.digitalinnovation.digionebank

fun main(){
   val digiOneBank = Banco(nome = "banco 1", numero = 1234567)
   println(digiOneBank)

   var cpy = digiOneBank.copy(nome = "banco 2")
   println(cpy)
}