package com.kotlin.study.扩展

import com.kotlin.study.类和对象.类.委托.标准委托.User

/**
 * Kotlin能够像C#一样，不需要任何设计模式就可以为一个类扩展新功能。这通过一个叫做_扩展_的特殊声明完成
 * 包括扩展函数和扩展属性
 * 扩展函数：
 * 接收者类型.函数签名
 * 值得指出的是，扩展函数是静态分发的，通过定义个扩展，并没有在一个类中插入新的成员，仅仅可以通过接收者类型的变量去调用这个新函数。
 * 调用扩展函数是由函数调用所在的表达式的类型决定，而不是由表达式运行时的求值结果决定的。
 * 简单点讲，即由变量的声明类型决定。这正好与Java中方法的动态绑定相反。
 *
 * 如果一个类有同样签名的成员函数和扩展函数,那么调用时成员函数总是优先被调用，扩展函数不会被调用到的
 *
 *
 */
fun User.sayHi(name: String) = println("Hellow everyone,my name is $name")

fun main(args: Array<String>) {
    var user = User()
    //扩展函数的调用和类本身的函数调用一样
    user.sayHi("Tom")
    printFoo(D())
}

/**
 * 静态分发举例：
 *
 */
open class C{
    fun foo() = " inner C"
}
class D:C()
//fun C.foo() = "C"
fun D.foo() = "D"
fun printFoo(c: C){
    println(c.foo())
}

/**
 * 可空接收者
 * 可以为可能为空的接收者定义扩展函数，这样的扩展即使调用时变量为null，仍然可以调用。并且可以在函数体内判断 this == null.
 * 这能让你在没有判空的情况下调用Kotlin中的toString().
 */
fun Any?.toString(): String{
    if(this == null)return "null"
    //空检测后，"this"会转换为非空类型。所以下面的toString()解析为Any类的成员函数
    return toString()
}
