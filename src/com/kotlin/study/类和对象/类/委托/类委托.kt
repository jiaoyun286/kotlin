package com.kotlin.study.类和对象.类.委托

/**
 * 委托模式，即代理模式
 * Java中的代理模式，代理类和被代理类实现同样的接口，代理类内部持有被代理类实例，在代理类的方法中执行的实际是传入的被代理类的方法实现
 * 在Kotlin的类委托中没那么麻烦的，代理类只需要实现与被代理类同样的接口，后面加上 by + 传入的被代理类参数名就可以，
 * 至于代理方法会自动实现的.
 *
 */

interface Base{
    fun print()
}

// 主构造函数的参数前面是否带var 有什么区别?
//不带只是参数，带了就是属性
class BaseImpl constructor(var promp :String = "被代理类方法") : Base{
    override fun print() {
        println(promp)
    }

}

/**
 * 使用默认代理实现
 */
class DerivedA(b: Base) : Base by b

/**
 * 自定义代理实现
 */
class DerivedB(b: Base) : Base by b{
    var b :Base
    init {
        this.b = b
    }

    override fun print() {
        b.print()
    }

}

fun main(args: Array<String>) {
    var b = BaseImpl()
    println("主构造函数中声明的属性：" + b.promp)
    DerivedA(b).print()
    DerivedB(BaseImpl("自定义代理")).print()
}