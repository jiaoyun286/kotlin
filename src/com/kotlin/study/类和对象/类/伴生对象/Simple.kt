package com.kotlin.study.类和对象.类.伴生对象

/**
 * Kotlin中没有静态的概念，伴生对象内声明的成员就类似Java类中的静态成员，调用和Java中的静态成员调用完全相同，都是通过类名调用的
 */
class Simple{
    companion object {
        var name = "zhangsan"

        fun f(){
            println("伴生对象中的方法")
        }
    }
}


fun main(args: Array<String>){
    println(Simple.name)
    Simple.f()


}