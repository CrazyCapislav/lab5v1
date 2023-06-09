package src.main.kotlin.commands
/**
 * Абстрактный класс для всех команд
 */
abstract class Command {

    abstract val commandName: String
    abstract fun writeString()
    fun writeCommandName(){
        println(commandName)
    }
}