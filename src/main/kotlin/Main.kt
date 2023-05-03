package src.main.kotlin

import src.main.kotlin.managers.CommandManager

fun main(args: Array<String>) {
   val start = CommandManager()
   if (args.isNotEmpty() && args[0].isNotBlank()) {
      start.start(args[0])
   } else {
      start.start("file1.txt")
   }
}




