package com.kotlin.study.类和对象.类.伴生对象

import java.util.regex.Pattern

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
//    println(Simple.name)
//    Simple.f()
    val line = "This order was placed for QT3000!OK?   67"
    val patten = "\\d+"
    val r = Pattern.compile(patten)
    val matcher = r.matcher(line)
    var i = 0
//    println("分组数："+matcher.groupCount())
    while (matcher.find()){
        println(matcher.group())
//        println(matcher.group(1))
//        println(matcher.group(2))
//        println(matcher.group(3))


    }



}