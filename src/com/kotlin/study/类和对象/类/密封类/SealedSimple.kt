package com.kotlin.study.类和对象.类.密封类

/**
 * 密封类
 * 特点：
 * 1.用来表示对类层级的限制。可以限定一个值只允许是某些指定的类型。
 * 2.其所有直接子类声明必须定义在密封类声明所在的文件内。
 * 3.密封类是抽象类，不允许创建实例；
 * 4.间接子类（孙子类）的声明可以放在任何地方；
 * 5.只允许有私有的构造器；
 *
 * 作用：
 * 当给when表达式传递一个密封类类型的变量时，可以验证分支语句是否覆盖了所有情况，这样就不必通过else语句来处理例外情况了
 *
 *
 *
 *
 */

sealed class SealedSimple {
    class Simple1 : SealedSimple()
    class Simple2 : SealedSimple()
    class Simple3 : SealedSimple()
}

class Simple4 : SealedSimple()

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
        is Simple4 ->
                println("simple4")

    }

    //when语句作为一个表达式
    var max = when(simple){
        is SealedSimple.Simple1 ->
            "SealedSimple.Simple1"

        is SealedSimple.Simple2 ->
            "SealedSimple.Simple2"
        is SealedSimple.Simple3 ->
            "SealedSimple.Simple3"
        is Simple4 ->
                "Simple4"

    }


}