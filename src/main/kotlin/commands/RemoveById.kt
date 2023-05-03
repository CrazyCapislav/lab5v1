package src.main.kotlin.commands

import src.main.kotlin.models.Flat

class RemoveById : Command() {
    override val commandName: String = "remove_by_id id"
    override fun writeString() {
        println("Удалить по id")
    }
    fun removeById(collection: HashSet<Flat>, id: Long){
        collection.removeIf { it.id == id}
    }
}