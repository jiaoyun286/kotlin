package com.kotlin.study.继承

/**
 * 继承
 */
open class Animal(name: String) {
}
class Dog(name: String):Animal(name){
    init {
        println("the dog name is ${name}")
    }
}