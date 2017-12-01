package com.kotlin.study.函数和Lambda表达式.lambda表达式

/**
 * @author JiaoYun
 * @date 2017/12/1 19:18
 *
 * Lambda表达式与匿名函数
 * 一个lambda表达式或匿名函数是一个“函数字面值”，即一个未声明的函数，但立即做为表达式传递
 *
 * Lambda表达式特点：
 * 1.总是被大括号括着
 * 2.其参数在 -> 之前声明，参数的类型可以省略
 * 3.函数体在 -> 后面
 *
 */

var sum = { a: Int, b: Int -> a + b }
var sum1: (Int, Int) -> Int = { a, b -> a + b }
fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection) {
        if (max == null || less(max, it)) {
            max = it
        }
    }
    return max
}

fun main(args: Array<String>) {
    var result = max(arrayListOf(1, 2)) {
        a, b ->
        a < b
    }
    println(result)
}
