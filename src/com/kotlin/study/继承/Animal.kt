package com.kotlin.study.继承

/**
 * 继承
 * 所有类都有一个共同的超类Any,如果类声明时没有指定超类，则默认继承自Any,类似Java中Object
 *
 * 如何声明类的超类？
 * 类头后面加"："后指定超类
 *
 * 如果类有主构造函数，则必须在主构造函数中使用主构造器的参数初始化基类。这个Java中道理是一样的，初始化子类必须先初始化父类
 * 如果类没有主构造函数，那么次构造函数可以使用super关键字来初始化基类
 *
 * 注意：
 * Kotin中所有的类都是final的，即不可继承的。如果类要被其他类继承，则这个类必须用open关键字标注
 *
 * 方法的覆盖：
 * 类中声明的方法默认也是final的，若要被子类覆盖也要用open标注，子类中复写的方法用override标注，并且这个复写的方法也是open的，添加final关注字标注可以关闭
 *
 * 属性覆盖：
 * 被覆盖的属性必须用open标记
 * 覆盖后的属性必须用override标记
 *
 * 可以使用var覆盖val，访问权限只可放大，不可缩小一个道理。反过来不行。
 *
 * 可以在子类的主构造器中使用override关键字标注属性，来覆盖父类中的属性
 *
 *
 *
 */

class Example //默认继承自Any

//open标注的类才可以被继承
open class Animal(name: String) {
}


//显式调用父类构造函数初始化父类
class Dog(name: String):Animal(name){
    init {
        println("the dog name is ${name}")
    }
}

class Cat : Animal{
    constructor(name: String):super(name){//没有主构造函数，次级构造函数使用super关键字调用父类构造函数初始化父类
        println("cat name is ${name}")
    }
}

/**
 * 覆盖规则：
 * 当一个类同时继承相同方法的不同实现时，则子类必须选择使用哪个父类的实现或提供自己的实现，
 *
 * 如何选择？
 * 在方法体内，super<父类名>.方法名
 *
 *
 *
 */

open class A{
    open fun f(){
        println("this A is fun")
    }
}

interface B {
    fun f(){
        println("this B is fun")
    }
}

class C : A(), B{  //A类中没有声明任何构造函数，所有会生成一个无参数构造，所以这里继承A时必须调用父类的无参构造。Java中会隐式调用。这里也体现了Kotlin力求显式的特点
    override fun f() {
        super<B>.f()
    }

}