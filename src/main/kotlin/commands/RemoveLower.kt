package src.main.kotlin.commands

import src.main.kotlin.models.Flat

class RemoveLower : Command() {
    override val commandName: String = "remove_lower {element}"
    override fun writeString() {
        println("Удалить id ниже чем")
    }
    fun removeLower(collection: HashSet<Flat>, id: Long){
        collection.removeIf { it.id < id}
    }
}