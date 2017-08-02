package com.kotlin.study.控制流

/**
 * for循环遍历：
 * 1.遍历区间
 * 2.遍历集合或数组
 * 3.通过索引遍历集合或数组
 * 4.使用库函数遍历集合或数组
 *
 * while循环和Java相同
 */

fun 遍历区间(){
    for( i in 1..5) println(i)
    println("====================")
    for(i in 5 downTo 0) println(i)
    println("====================")
    for(i in 5 downTo 0 step 3) println(i)
}

val  arrayInt = intArrayOf(1,2,3,4,5,6)
fun 遍历集合(){
    for(it in arrayInt) println(it)
}

fun 通过索引遍历集合或数组(){
    for(it in arrayInt.indices){
        println("索引值是${it}")
        println("${it}位置的原生值是${arrayInt[it]}")
    }
}

fun 使用库函数遍历(){
    for ((index,value) in arrayInt.withIndex()){
        println("the element at ${index} value is ${value}")
    }

}

fun main(args: Array<String>) {
//    遍历区间()
//    遍历集合()
//    通过索引遍历集合或数组()
    使用库函数遍历()
}