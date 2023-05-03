package src.main.kotlin.commands

class Help : Command() {
    override val commandName: String = "help"
    override fun writeString() {
        println("Все команды: add, help, show, addIfMax, clear, save, update_id, removeLower, removeGreater, execute, UTTMOF, averageMetro, info, exit, removeAllByNOR, removeById")
    }
}