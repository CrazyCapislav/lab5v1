package src.main.kotlin.managers
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator
import src.main.kotlin.commands.*
import src.main.kotlin.models.Flat
import src.main.kotlin.other.MyHashSet
import java.io.File
import java.io.FileOutputStream

class CommandManager {
    fun start(arg:String){
        val help = Help()
        val add = Add()
        val show = Show()
        val save = Save()
        val clear = Clear()
        val updateId = UpdateId()
        val addIfMax = AddIfMax()
        val execute = ExecuteScript()
        val averageOfTimeToMetroOnFoot = AverageOfTimeToMetroOnFoot()
        val UTTMOF = PrintUniqueTimeToMetroOnFoot()
        val removeGreater = RemoveGreater()
        val removeLower = RemoveLower()
        val removeById = RemoveById()
        val removeAllByNumberOfRooms = RemoveAllByNumberOfRooms()
        var arrayId : MutableList<Long> = mutableListOf()
        val collectionFolder: String = arg.ifBlank {
            "file1.txt"
        }
        var file = File(collectionFolder)
        if (!file.exists()) {
            println("Файл не найден: $collectionFolder")
            file = File("file1.txt")
            file.createNewFile()
            println("Создан новый файл: file1.txt")
            println("Запись в файл: file1.txt")
            val outputStream = FileOutputStream(file)
            val hashSet = HashSet<Flat>()
            val xmlMapper = XmlMapper.builder().build()
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true)
            val xmlCollecion = xmlMapper.writeValueAsString(hashSet)
            outputStream.write(xmlCollecion.toByteArray())
            outputStream.close()

            println("Содержимое файла: $collectionFolder")
            val inputStream = file.inputStream()
            val newContent = inputStream.bufferedReader().use { it.readText() }
            println(newContent)
            inputStream.close()
        }
        val xmlMapper = XmlMapper.builder().build()
        var xmlHashSet: HashSet<Flat> = xmlMapper.readValue(file, object : TypeReference<HashSet<Flat>>() {})
        val initDate = MyHashSet(xmlHashSet).creationDate
        while(true) {
            arrayId = mutableListOf()
            xmlHashSet.forEach { arrayId.add(it.id) }
            println("Введи команду, чтобы продолжить! (help - узнать все команды)")
            when (val read = readLine()) {
                "help" -> help.writeString()
                "add" -> {add.start(xmlHashSet, arrayId);xmlHashSet.forEach { arrayId.add(it.id) }}
                "show" -> show.showElement(xmlHashSet)
                "exit" -> break
                "save" -> save.saveChanges(xmlHashSet, collectionFolder)
                "clear" -> {clear.clear(collectionFolder); xmlHashSet = xmlMapper.readValue(file, object : TypeReference<HashSet<Flat>>() {})}
                "info" -> {
                    println("Тип коллекции - HashSet")
                    println("Дата инициализации - $initDate")
                    println("Размер - ${xmlHashSet.size}")
                }
                "averageMetro" -> averageOfTimeToMetroOnFoot.averageMetro(xmlHashSet)
                "UTTMOF" -> UTTMOF.uniqueTime(xmlHashSet)
                null -> {println("WTF"); break
                }
                else -> {
                    val parts = read.split(" ")
                    if (parts.size == 2){
                        when(parts[0]){
                            "update_id" -> {
                                val id = parts[1].toLongOrNull()
                                if (id != null) {
                                    updateId.update(xmlHashSet, id)
                                } else {
                                    println("Неверный формат команды")
                                }
                            }
                            "addIfMax" -> {
                                val id = parts[1].toLongOrNull()
                                if (id!=null){
                                    addIfMax.addIfM(xmlHashSet, id, arrayId)
                                }
                                else {
                                    println("Неверный формат команды")
                                }
                            }
                            "execute" ->{
                                val folder = parts[1]
                                if (folder.isNotBlank()) {
                                    execute.execute(folder, collectionFolder)
                                } else {
                                    println("Неверный формат команды")
                                }
                            }
                            "removeLower" ->{
                                val folder = parts[1]
                                if (folder.isNotBlank()) {
                                    removeLower.removeLower(xmlHashSet, folder.toLong())
                                } else {
                                    println("Неверный формат команды")
                                }
                            }
                            "removeGreater" ->{
                                val folder = parts[1]
                                if (folder.isNotBlank()) {
                                    removeGreater.removeGreater(xmlHashSet, folder.toLong())
                                } else {
                                    println("Неверный формат команды")
                                }
                            }
                            "removeAllByNOR" ->{
                                val folder = parts[1]
                                if (folder.isNotBlank()) {
                                    removeAllByNumberOfRooms.removeByRooms(xmlHashSet, folder.toInt())
                                } else {
                                    println("Неверный формат команды")
                                }
                            }
                            "removeById" ->{
                                val folder = parts[1]
                                if (folder.isNotBlank()) {
                                    removeById.removeById(xmlHashSet, folder.toLong())
                                } else {
                                    println("Неверный формат команды")
                                }
                            }
                            else->{
                                println("Неверный формат команды")
                            }
                        }
                    }
                    else {
                        println("Неверный формат команды")
                    }
                }
            }
        }
        println("Выход")
    }
}