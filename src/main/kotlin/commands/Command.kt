package src.main.kotlin.commands

abstract class Command {
    abstract val commandName: String
    abstract fun writeString()
    fun writeCommandName(){
        println(commandName)
    }
}