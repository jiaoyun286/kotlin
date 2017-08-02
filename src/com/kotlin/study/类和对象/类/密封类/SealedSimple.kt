package com.kotlin.study.类和对象.类.密封类

/**
 * 密封类
 * 子类的类型是有限的集合，即是密封类子类数量是确定的。类似枚举类的实例数量是确定的一个道理
 * 在when语句中，可以避免写else分支，可以确定是否覆盖了所有分支条件
 *
 */

sealed class SealedSimple {
    class Simple1 : SealedSimple()
    class Simple2 : SealedSimple()
    class Simple3 : SealedSimple()
}

fun main(args:Array<String>){
    var simple = SealedSimple.Simple3()
    f(simple)



}

fun f(simple: SealedSimple) = {
    //when语句作为逻辑控制语句
  when(simple){
        is SealedSimple.Simple1 ->
            println("SealedSimple.Simple1")
        is SealedSimple.Simple2 ->
            println("SealedSimple.Simple2")
        is SealedSimple.Simple3 ->
            println("SealedSimple.Simple3")

    }

    //when语句作为一个表达式
    var max = when(simple){
        is SealedSimple.Simple1 ->
            "SealedSimple.Simple1"

        is SealedSimple.Simple2 ->
            "SealedSimple.Simple2"
        is SealedSimple.Simple3 ->
            "SealedSimple.Simple3"

    }


}