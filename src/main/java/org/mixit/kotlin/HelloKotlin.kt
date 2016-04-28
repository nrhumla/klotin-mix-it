package org.mixit.kotlin

data class Person(val name: String, val firstName: String)

fun main(args: Array<String>) {
    (1..10).forEach { println(Foo(it)) }

    val person = Person("Humla", "Nadia")

    with(person) {
        println(name)
        println(firstName)
        println("Hello ${this.firstName}")
    }

}

data class Foo(val i:Int)

fun Int.foo() = Foo(this)