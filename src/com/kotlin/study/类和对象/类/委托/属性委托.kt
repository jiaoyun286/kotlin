package com.kotlin.study.类和对象.类.委托

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Example{
    var p:String by Delegate()

    /**
     * 延迟属性
     * lazy()接收一个lambda并返回一个Lazy<T>实例的函数，这个返回的实例可以作为实现延迟属性的委托。
     * 只能用在val类型的属性
     * 第一次被访问时，get()会执行传递给lazy()函数的lambda表达式并将表达式的结果赋值给属性，然后返回
     * 第二次被访问时，只会返回属性的值
     *
     *
     */
    val lazyValue: String by lazy({
        println("computer")
        "hello"

    })

    /**
     * 默认，对于lazy属性的求值是线程安全，如果加上下面的参数，可以切换成线程不安全的
     */
    val unSafeLazyValue: String by lazy(LazyThreadSafetyMode.NONE){
        "unSafeLazyValue"
    }



}

class Delegate{
    operator fun  getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef,thank you for delegatein ${property.name} to me!"
    }

    operator fun  setValue(example: Example, property: KProperty<*>, s: String) {

    }


}

fun main(args: Array<String>) {
//    val e = Example()
//    println(e.p)

    val user = User()
    user.name = "云梦泽"


}

class User{
    var name: String by Delegates.observable("zhangsan"){
        property, oldValue, newValue ->  println("$oldValue -> $newValue")
    }

    val firstName: String by Delegates.vetoable("张"){
        property, oldValue, newValue ->  println("$oldValue -> $newValue")
        if(oldValue.equals(newValue)) false else true
    }
}