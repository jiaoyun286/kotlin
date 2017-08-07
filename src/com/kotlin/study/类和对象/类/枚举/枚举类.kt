package com.kotlin.study.类和对象.类.枚举

enum class Direction{
    NORTH,SOUTH,WEST,EAST
}

enum class Color(val rgb: Int){
    RED(0xFF0000),GREEN(0x00FF00),BLUE(0x0000FF)
}

fun main(args: Array<String>) {
//    println(enumValues<Color>().joinToString { it.name })
    val colors = Color.values()
    colors.forEach { println(it.name) }

}

/**
 * 枚举类也可以声明自己的匿名类。如下面的例子，
 * ProtocolState枚举类定义了抽象的方法，而抽象类不能创建对象，由于其每个枚举值就是它的实例，就和JAVA中创建抽象类的匿名对象一样，
 * 声明有抽象方法的枚举类的值，实际上是这个枚举类的匿名子类对象。
 *
 */
enum class ProtocolState{
    WRITING{
        override fun signal(): ProtocolState {
            return TALKING
        }

    },
    TALKING{
        override fun signal(): ProtocolState {
           return WRITING
        }

    };//枚举值和枚举类的成员要用分号隔开
    abstract fun signal(): ProtocolState


}