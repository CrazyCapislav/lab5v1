package src.main.kotlin.commands

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import src.main.kotlin.models.Flat
import src.main.kotlin.other.MyHashSet
import java.io.File

class ExecuteScript : Command() {
    override val commandName: String = "execute_script file_name"
    override fun writeString() {
        println("Запуск скрипта")
    }
    fun execute(scriptFolder: String, collectionFolder: String){
        val scriptFile = File(scriptFolder)
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
        if (!scriptFile.exists()) {
            println("Файл скрипта не существует: $scriptFolder")
            return
        }
        var file = File(collectionFolder)
        val xmlMapper = XmlMapper.builder().build()
        var xmlHashSet: HashSet<Flat> = xmlMapper.readValue(file, object : TypeReference<HashSet<Flat>>() {})
        val initDate = MyHashSet(xmlHashSet).creationDate
        val lines = scriptFile.readLines()
        for (line in lines) {
            val input = line.trim()
            println(input)
            if (input.isEmpty()) {
                continue
            }
            when (input) {
                "help" -> help.writeString()
                "add" -> {add.start(xmlHashSet, arrayId);xmlHashSet.forEach { arrayId.add(it.id) }}
                "show" -> show.showElement(xmlHashSet)
                "exit" -> break
                "save" -> save.saveChanges(xmlHashSet, collectionFolder)
                "clear" -> {clear.clear(collectionFolder); xmlHashSet = xmlMapper.readValue(file, object : TypeReference<HashSet<Flat>>() {})}
                "info" -> {
                    println("Тип коллекции - HashSet");
                    println("Дата инициализации - $initDate")
                    println("Размер - ${xmlHashSet.size}")
                }
                "averageMetro" -> averageOfTimeToMetroOnFoot.averageMetro(xmlHashSet)
                "UTTMOF" -> UTTMOF.uniqueTime(xmlHashSet)
                null -> {println("WTF"); break
                }
                else -> {
                    val parts = input.split(" ")
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
}
}
