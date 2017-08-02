package com.kotlin.study.控制流


/**
 * if语句作为表达式
 * 1.如果条件分支只有一条语句可以省略大括号
 * 2.else分支是必须的
 *
 * 作为表达式使用时，表达式的结果是一个值，所以:
 * if表达式：
 * 1.可以作为方法的返回值；
 * 2.可以用来初始化一个变量；
 *
 */

//作为返回值
val a = 1
val b = 2
fun if作为表达式() = if(a > b) a else b

//用来初始化属性
val 用if表达式初始化 = if(a > b) a else b
/**
 * if表达式分支语句中包含多条语句
 * 每条语句占一行
 * 每个分支的最后一条语句会作为所在分支的值
 */
val if语句包含多条语句 = if(a > b){
    println("条件为真")
    a
}else if(true){
    println("条件为假")
    b
}else{
    -1
}

fun if语句用作流程控制(){
    if(a < b)
        println("a < b")
}

fun main(args: Array<String>) {
    println("if作为表达式${if作为表达式()}")
    println("if表达式初始化属性${用if表达式初始化}")
    println("if表达式包含多条语句${if语句包含多条语句}")
    println("if语句用作流程控制${if语句用作流程控制()}")
}