package com.kotlin.study.基本类型

/**
 * Kotlin中所有的东西都是对象。基本类型在Kotlin中也有特殊的内部表示类型，尽管这些类型是引用类型，但使用起来和Java中的基本类型
 * 基本类似。
 * 但是，不存在隐式的类型转换，所以同类型的变量相互赋值时要进行显式类型转换。
 * 如果可以通过上下文推断出变量的类型，也不需要显式类型转换
 *
 */
val a = 123
val b = 0x0f
val c = 0b0001

//不同类型的变量相互赋值需要进行显式的类型转换
val m: Int = 1
val n: Long = m.toLong()
val x: Int = n.toInt()

// y 的类型可以通过上下问题推断出来 Long + Int => Long
val y = n+1

/**
 * 字符类型用Char表示。它不能直接当作数字,需要显式转换未数字
 */
fun check(c: Char){
    if(c.toInt() == 1){

    }
}

/**
 * 数组
 * 三种创建方式：
 * 1.库函数 arrayOf(1,2,3)创建，并传递元素
 * 2.库函数 arrayOfNulls(5) 创建指定长度的空数组
 * 3.工厂函数 Array(5, { i -> (i * i).toString() }) 接收数组大小和一个函数参数
 *
 */

fun  创建数组(){
    val array = arrayOf(1,2,3)
    val arrayEmpty = arrayOfNulls<Int>(5)
    val factoryFun = Array(3){
        i:Int -> i
    }
    //数组元素的访问和Java相同，不过[]运算符会调用get和set
    val value1 = array[0]

    for (i in array) { //数组的遍历

    }
}

/**
 * 字符串
 * 字符串最重要的特性就是字符串模板
 */

fun 字符串模板(){
    val q = "***"
    val str = "字符串模板测试$q" +"&&&---" + "${a + b}"// 这里$q就是字符串模板，运行时会被替换为q的字面值,若是表达式要用{}包裹起来

    val unit = "$"
    val price = "$unit 99.99" //字符串模板若不带大括号后面要有空格或其他特殊字符
    val price1 = "${'$'}999.99"

    println(price1)
}

fun main(args: Array<String>) {
    println(字符串模板())
}
