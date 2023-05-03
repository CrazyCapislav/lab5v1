package src.main.kotlin

import src.main.kotlin.managers.CommandManager
/**
 * Класс, содержащий точку входа в программу.
 *
 *
 */
fun main(args: Array<String>) {
   val start = CommandManager()
   if (args.isNotEmpty() && args[0].isNotBlank()) {
      start.start(args[0])
   } else {
      start.start("file1.txt")
   }
}




