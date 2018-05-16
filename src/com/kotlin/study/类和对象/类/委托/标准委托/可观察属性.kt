package com.kotlin.study.类和对象.类.委托.标准委托

import kotlin.properties.Delegates

class User{
    /**
     * Delegates.observable()接受两个参数：初始值和属性值被改变后的处理程序（handler）
     * handler 就是个有三个参数，没有返回值的lambda表达式，每次属性值改变都会执行这个lambda表达式
     *
     */
    var name: String by Delegates.observable("zhangsan"){ _, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

    /**
     * 如果你想在属性值改变前，对将要赋的值做一些判断，你可以用Delegates.vetoable()，与上面不同的是，
     * 作为它第二个参数的lambda表达式在赋值前会被执行，返回一个布尔值，并根据这个返回结果决定是否执行赋值
     */
    val firstName: String by Delegates.vetoable("张", { _, oldValue, newValue ->
        println("$oldValue -> $newValue")
        val b = oldValue != newValue
        b
    })
}

fun main(args: Array<String>) {

    val user = User()
    user.name = "云梦泽"
}