package com.kotlin.study.控制流

/**
 * 作为表达式使用，可以直接当作函数的返回值
 * 注意：when表达式并不能像if表达式一样可以用来初始化属性
 *
 * when表达式带参数
 * 可以作为函数的返回值，参数将会参与分支条件的判断，判断结果为真分支会执行
 * when表达式不带参数
 * 可以作为函数返回值，也可以用作初始化变量
 *
 * 和if语句一样，when语句作为表达式使用时else条件分支也是不能省的，除非编译器可以判定你已经把所有可能性已经包含在判断条件内
 *
 */
fun when作为表达式(x: Int) = when(x){
    1 -> 1
    2 -> 2
    else -> {
        println("no thing")
    }
}

// when表达式 中可以使用 in、 !in 、is 、!is  关键字
fun f(x: Any) = when (x){
    in 1..10 -> println("x is in the range")
    in validNumbers -> println("x is valid")
    !in 60..70 -> println("x outside the range")
    a is Int -> println("x is Int")//使用外部定义的变量
    is Int -> println("x is Int") //使用传入的参数
    100,200 -> println("x value is ${x}")
    800 -> println("x value is ${x}")
    else -> println("none of the above")
}

/**
 * when表达式也可以作为初始化器给变量赋值，带参数时只能用在函数内部给变量赋值
 */
var max = when{
    a is Int -> a
    a > b -> b
    else -> a
}

fun f() = when{
    a > b -> b
    else -> a
}

var validNumbers = arrayListOf(20,30,40)
fun main(args: Array<String>) {
 println(when作为表达式(100))
    println(f(20))

}


