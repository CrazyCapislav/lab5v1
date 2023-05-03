package src.main.kotlin.commands

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import src.main.kotlin.models.Flat
import java.io.File
import java.io.FileOutputStream

class Save : Command() {
    override val commandName: String = "save"
    override fun writeString() {
        println("Сохранение...")
    }
    fun saveChanges(collection: HashSet<Flat>, folder: String){
        val xmlMapper = XmlMapper.builder().build()
        val file = File(folder)
        val outputStream = FileOutputStream(file)
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, collection)
    }
}