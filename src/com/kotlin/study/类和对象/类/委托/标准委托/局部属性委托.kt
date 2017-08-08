package com.kotlin.study.类和对象.类.委托.标准委托

import com.kotlin.study.类和对象.类.委托.Delegate

/**
 * 不仅仅类的成员位置定义的属性可以声明为委托属性，包级别和函数内的局部变量都可以声明为委托属性
 *
 * 将一个局部变量声明为延迟初始化的委托属性时，延迟初始化用到的lambda表达式可以通过函数的参数传入，来控制局部变量的初始化过程
 *
 */

var varte by Delegate()
val 包级延迟初始化属性 by lazy { "Hellow world" }
fun example(computeFoo: () -> String){
    val momoizedFoo by lazy(computeFoo)
    var 局部属性委托 by Delegate()
    var a = 2

    if(a > 0 && !momoizedFoo.isEmpty()){
        println("延迟初始化的属性值是:$momoizedFoo")
    }else{
        println("局部属性委托:$局部属性委托")
    }
}

fun main(args: Array<String>) {
    example {
        println("延迟初始化属性")
        "凛冬将至"
    }

    example {
        println("延迟初始化属性2")
        ""
    }

    println("包级别的属性的委托值是：$varte")
    println("包基本延迟初始化的属性值是：$包级延迟初始化属性")

}