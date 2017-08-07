package com.kotlin.study.类和对象.类.泛型

/**
 * 在Java中的泛型是不型变的，这意味着List<Object>并不是List<String>的基类。
 * 编译器认为，苹果是水果的子类，即苹果是水果。但是，装苹果的盘子并不是装水果的盘子。
 * 虽然容器都是同样的容器，容器里面的东西也有继承关系，但是装了东西的容器就不再具有继承关系了。
 * 为什么是不型变的？
 * https://www.zhihu.com/question/20400700
 */
open class Base
class Device : Base()

//生命处形变，T只会被生产，而不会被消费，即只会作为方法的返回值，不会作为入参。
//此时，我们可以称类Source在参数T上是协变的，或者说T是协变的类型参数。也可以认为Source是T的生产者
class Source<out T>

fun main(args: Array<String>) {
    var source: Source<Base> = Source<Device>()
}

/**
 * Comparable的类型参数是用in标注的,所以只可以作为消费者，不能作为生产者
 *
 */
fun 逆变(x: Comparable<Number>){
    x.compareTo(2.0)
    val y: Comparable<Double> = x

}