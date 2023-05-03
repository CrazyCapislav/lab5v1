package src.main.kotlin.commands

import src.main.kotlin.models.Flat

class PrintUniqueTimeToMetroOnFoot : Command() {
    override val commandName: String = "print_unique_time_to_metro_on_foot"
    override fun writeString() {
        println("Уникальные расстояния до метро")
    }
    fun uniqueTime(collection: HashSet<Flat>) {
        println(collection.map { it.timeToMetroOnFoot }.distinct())

    }
}