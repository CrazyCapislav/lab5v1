package src.main.kotlin.commands

import src.main.kotlin.models.Flat

//
class AverageOfTimeToMetroOnFoot : Command() {
    override val commandName: String = "average_of_time_to_metro_on_foot"
    override fun writeString() {
        println("Среднее время до метро")
    }
    fun averageMetro(collection: HashSet<Flat>){
        val averageM = collection.map { it.timeToMetroOnFoot }.average()
        println(averageM)

    }
}