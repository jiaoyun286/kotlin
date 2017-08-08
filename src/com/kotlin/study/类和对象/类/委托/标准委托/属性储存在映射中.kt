package com.kotlin.study.类和对象.类.委托.标准委托

import com.kotlin.study.基本类型.m

/**
 * 类的属性可以委托给一个映射表，当访问相应的属性时,会将映射表内的值返回。
 * 如果映射表内缺少以要访问的属性的属性名为key的元素，就会报错
 * 所以，安全起见，最好判断映射表内是否有要访问的元素
 */
class Person(val map: Map<String, Any?>) {

    val name: String by map
    val age: Int by map
}

/**
 * 要作为var属性的的委托需要用MutableMap
 */
class Student(val map: MutableMap<String, Any?>){
    var name:String by map
    var age:Int by map
}

fun main(args: Array<String>) {
    var person = Person(mapOf(
            "age" to 11
    ))
    if (person.map.containsKey("name")) {
        println("my name is ${person.name},my age is ${person.age} years old")


    } else {
        println("没有要访问的元素")
    }

    var student = Student(mutableMapOf(
            "name" to "张三",
            "age" to 17
    ))

    student.name = "李四"
    println("my name is ${student.name},my age is ${student.age} years old")


}
