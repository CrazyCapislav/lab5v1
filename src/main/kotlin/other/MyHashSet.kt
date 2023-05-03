package src.main.kotlin.other

import java.time.LocalDateTime
class MyHashSet<T>(private val set: HashSet<T>) {
    val creationDate = LocalDateTime.now().toString()

    fun add(element: T): Boolean {
        return set.add(element)
    }

    fun remove(element: T): Boolean {
        return set.remove(element)
    }

    override fun toString(): String {
        return "MyHashSet(creationDate=$creationDate, set=$set)"
    }
}
