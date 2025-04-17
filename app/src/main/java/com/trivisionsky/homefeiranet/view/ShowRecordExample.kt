package com.trivisionsky.homefeiranet.view

class PersonBuilder {

    private val attributes = mutableMapOf<String, String>()


    fun setName(name: String): PersonBuilder {
        attributes["Name"] = name
        return this
    }


    fun setAge(age: Int): PersonBuilder {
        attributes["Age"] = age.toString()
        return this
    }

    fun setAddress(address: String): PersonBuilder {
        attributes["Address"] = address
        return this
    }

    fun setCustomAttribute(key: String, value: String): PersonBuilder {
        attributes[key] = value
        return this
    }

    fun build(): Person {
        return Person(attributes)
    }
}

data class Person(private val attributes: Map<String, String>) {

    fun getAttribute(key: String): String? {
        return attributes[key]
    }

    override fun toString(): String {
        return attributes.entries.joinToString(separator = "\n") { "${it.key}: ${it.value}" }
    }
}



