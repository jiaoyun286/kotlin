package com.kotlin.study.类和对象.类.构造函数

/**
 * Created by Administrator on 2017/8/1.
 * 1.声明类使用class关键字
 * 类的三要素：类名、类头、类体
 * 类头包括类型参数和主构造函数
 *
 * 主构造函数：
 * 声明位置：
 * 类头的一部分，跟在类名后，使用constructor关键字声明；
 *
 * 特殊点：
 * 如果主构造函数没有可见性修饰符和注解可以省略constuctor关键字
 * 主构造函数不包含任何代码。初始化代码可以放在以init开头的初始化块中.
 * 主构造函数中的参数可以在可以在初始化块中使用和类体内声明的属性的初始化起中使用,其他地方不能用
 *
 * 次构造函数：
 * 在类体内声明，前缀为constuctor;
 * 如果有主构造函数，次构造函数必须直接或间接委托给主构造函数，委托给同一个类的另一个构造函数用this关键字
 *
 * 如果没有声明任何构造函数，则默认会生成一个无参的主构造函数
 * 如果主构造函数的参数都有默认值，编译器也会生成一个无参数构造，因为这个无参构造函数也会委托给主构造函数，
 * 所以无参构造函数会使用主构造函数参数的默认值
 *
 * 创建类的实例
 * 像普通的函数调用，没有new关键字
 * Person()
 *
 *
 *
 *
 */
class Person constructor(name: String = "Tom"){
    var myName = name
    init {
        //name = "李四" //参数默认是val，是不可变的
        println("this person's name is ${name}")
    }

//    fun changeMyName(){  //不能在类体内声明的方法中使用主构造函数中的参数
//        myName = name
//    }

    fun shyHellow() = println("my name is ${myName}")

    // 次构造函数
    constructor(name: String,age: Int):this(name){ //直接委托给主构造函数
        println("次构造函数，我的名字是${name},我的年龄是${age}")
    }

    constructor(name: String,age: Int,heigh: Float):this(name,age){//间接委托给主构造函数
        println("次构造函数，我的名字是${name},我的年龄是${age},身高是${heigh}")
    }
}

fun main(args: Array<String>){
   val person = Person() //如果主构造函数的所有参数都要默认值，编译器会生成一个无参构造，并且使用主构造函数的默认值，因为使用这个无参构造时，会委托给主构造函数
    person.shyHellow()

}