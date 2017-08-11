package com.kotlin.study.类和对象.类.委托.标准委托

/**
 *
 *
 * 延迟属性
 * lazy()接受一个lambda并返回一个Lazy<T>实例的函数，这个返回的实例可以作为实现延迟属性的委托。
 * 只能用在val类型的属性
 * 第一次被访问时，get()会执行传递给lazy()函数的lambda表达式并将表达式的结果赋值给属性，然后返回
 * 第二次被访问时，只会返回属性的值
 *
 *由于Lazy没有setVlaue函数，所有不能用于var属性
 */
val lazyValue: String by lazy({
    println("computer")
    "hello"

})

/**
 * 默认，对于lazy属性的求值是线程安全.
 * 如果初始化委托的同步锁不是必需的，允许多个线程同时执行，那么可以将LazyThreadSafetyMode.PUBLICATION  作为参数传递给  lazy()  函数
 * 如果确定初始化只会发生在单个线程，那么可以使用LazyThreadSafetyMode.NONE  模式， 它不会有任何线程安全的保证和相关的开销。
 */
val unSafeLazyValue: String by lazy(LazyThreadSafetyMode.NONE){
    "unSafeLazyValue"
}

fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
}