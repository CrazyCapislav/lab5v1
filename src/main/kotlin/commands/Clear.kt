package src.main.kotlin.commands

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator
import src.main.kotlin.models.Flat
import java.io.File
import java.io.FileOutputStream

class Clear : Command() {
    override val commandName: String = "clear"
    override fun writeString() {
        println("Очистка коллекции")
    }
    fun clear(folder: String) {
        val outputStream = FileOutputStream(File(folder))
        val hashSet = HashSet<Flat>()
        val xmlMapper = XmlMapper.builder().build()
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true)
        val xmlCollecion = xmlMapper.writeValueAsString(hashSet)
        outputStream.write(xmlCollecion.toByteArray())
        outputStream.close()
    }
}