package com.kotlin.study.类和对象.类.对象

/**
 * 对象声明，object后跟一个名词。实际就是一个单例类型。
 * 使用对象只需要用后面的名称直接调用即可，名称就代表唯一实例。
 * 并且，对象声明可以有超类
 *
 * 对象声明，不能声明在局部作用域，即函数内部
 */
object SingleInstance : SuperInterface{
    override fun superFun() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun foo(){
        //do some thing
        println("单例类方法")
    }
}

interface SuperInterface{
    fun superFun()
}

fun main(args: Array<String>) {
    SingleInstance.foo()
}