package com.kotlin.study.类和对象.类.对象

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * 有时，我们需要创建一个对某个类做了轻微改动的类的对象，而不用显式低的声明新的子类。在JAVA中我们通常用匿名内部类来实现。
 * 而在Kotlin中我们用对象表达式。
 * 语法：object: 基类(){
 *   //要改变的实现
 * }
 */
open class A(x: Int){
    open val y = x
}

interface B

//多个基类用,隔开
val ab: A = object : A(2),B{
    override val y = 15
}

/**
 * 任何时候，我们如果只需要一个对象，而不需要任何对象，我们可以在家在object后面的大括号内写实现
 *
 */
fun foo(){
    val adHoc = object {
        val x = 0
        val y = 1
    }

    println(adHoc.x + adHoc.y)
}

/**
 * 如果把你们对象赋值给公有成员或作为公有方法的返回值，那么给公有属性或公有方法的返回值类型是这个你们对象的超类类型
 * 如果匿名对象没有声明任何超类，就会是Any.此时在匿名对象内声明的成员就不可以访问了。
 * 为什么不能访问？
 * 上面都说了类型不对嘛，超类里面怎么会知道子类里面新添加了什么成员。
 */
class C{
    private fun foo() = object {
        fun 私有方法返回的匿名对象方法(){
            println(this.javaClass.simpleName)
        }
    }

    public fun publicFoo() = object {
        fun 公有方法返回的匿名对象方法(){
            println(javaClass.simpleName)

        }
    }

    fun 调用私有方法(){
        foo().私有方法返回的匿名对象方法()
    }

    fun bar(){
        foo().私有方法返回的匿名对象方法()
        //publicFoo().公有方法返回的匿名对象方法()
    }


}

fun main(args: Array<String>) {
    val c = C()
    println(c.publicFoo().javaClass)
    c.调用私有方法()
}

/**
 * 在对象表达式的内部可以访问它声明所在作用域的成员
 */
fun countClicks(window: JComponent){
    var clickCount = 0
    var enterCount = 0
    window.addMouseListener(object :MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            clickCount++
        }


    })
}