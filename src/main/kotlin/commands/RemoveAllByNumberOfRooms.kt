package src.main.kotlin.commands

import src.main.kotlin.models.Flat

class RemoveAllByNumberOfRooms : Command() {
    override val commandName: String = "remove_all_by_number_of_rooms numberOfRooms"
    override fun writeString() {
        println("Удалить все с числом комнат")
    }
    fun removeByRooms(collection: HashSet<Flat>, numberOfRooms: Int){
        collection.removeIf { it.numberOfRooms == numberOfRooms}
    }
}