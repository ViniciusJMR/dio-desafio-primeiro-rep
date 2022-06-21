package one.digitalinnovation.digionebank

fun main(){
   //Data class
   val digiOneBank = Banco(nome = "banco 1", numero = 1234567)
   println(digiOneBank)

   var cpy = digiOneBank.copy(nome = "banco 2")
   println(cpy)

   //Enum
   ClienteTipo.values().forEach {
      println("${it.name} - ${it.descricao}")
   }
}