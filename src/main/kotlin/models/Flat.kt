package src.main.kotlin.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.time.LocalDateTime

@JacksonXmlRootElement(localName = "item")
class Flat(
    @JacksonXmlProperty(localName = "id")
    val id: Long = 0,
    @JacksonXmlProperty(localName = "name")
    var name: String = "",
    @JacksonXmlProperty(localName = "coordinates")
    var coordinates: Coordinates,
    @JacksonXmlProperty(localName = "area")
    var area: Int,
    @JacksonXmlProperty(localName = "numberOfRooms")
    var numberOfRooms: Int,
    @JacksonXmlProperty(localName = "livingSpace")
    var livingSpace: Double,
    @JacksonXmlProperty(localName = "timeToMetroOnFoot")
    var timeToMetroOnFoot: Int,
    @JacksonXmlProperty(localName = "furnish")
    var furnish: Furnish?,
    @JacksonXmlProperty(localName = "house")
    var house: House? = House(),
    @JacksonXmlProperty(localName = "creationDate")
    var creationDate: String = LocalDateTime.now().toString()
){
    override fun toString(): String {
        return "$name, $creationDate, $id, $coordinates, $area, $numberOfRooms, $livingSpace, $timeToMetroOnFoot, $furnish, $house"
    }

    fun showDate(){
        println(creationDate)
    }
}
//fun getID():Long{return id}