package src.main.kotlin.commands

import src.main.kotlin.models.Flat
/**
 * Один из классов команд
 */
class Show: Command(){

    override val commandName: String = "show"
    override fun writeString() {
        println("Имена элементов коллекции")
    }
    fun showElement(collection: HashSet<Flat>) {
        collection.forEach { el ->
            println(el.toString())
        }
    }
}