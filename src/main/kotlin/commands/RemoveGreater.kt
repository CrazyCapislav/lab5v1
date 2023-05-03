package src.main.kotlin.commands

import src.main.kotlin.models.Flat
/**
 * Один из классов команд
 */
class RemoveGreater : Command() {

    override val commandName: String = "remove_greater {element}"
    override fun writeString() {
        println("Удалить id выше чем")
    }
    fun removeGreater(collection: HashSet<Flat>, id: Long){
        collection.removeIf { it.id > id}
    }
}