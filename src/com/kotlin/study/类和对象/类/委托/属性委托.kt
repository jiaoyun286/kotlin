package com.kotlin.study.类和对象.类.委托

import com.kotlin.study.类和对象.类.委托.标准委托.lazyValue
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 有一些常见的属性类型，虽然我们可以在每次需要的时候都手动实现一次，但是这完全是没有必要的，如果能够为所有使用的地方提供统一的实现
 * 可能会更好一些。例如：
 * 延迟属性：其值只在首次访问时计算；
 * 可观察属性：当属性值发生变化时，监听器会收到通知；
 * 把多个属性储存在一个映射(map)中，而不是每个存在单独的字段中;
 *
 * 为了涵盖这些情况，Kotlin支持属性委托：
 * 语法：var/val <属性名>: <属性类型> by <表达式>
 * 在by后面的表达式就是委托，属性的get()和set()会被委托给这个委托的getValue()和setValue()方法。
 * 属性的委托不需要实现任何借口，但要提供getValue()和setValue()函数。
 * 声明代理类是可以不添加setValue和getValue函数，一旦把这个类作为某个属性的代理，编译器检查到这个类没有声明相应的函数，就会报错，
 * 此时可以再修复添加
 *
 */
class Example{
    var p:String by Delegate()
}

class Delegate {

    /**
     * 当我们从被委托属性p读取是，将调用这个函数，并将这个函数的返回值作为被委托属性的值
     * @example 读取被委托属性的对象
     * @property 保存里对被委托属性的描述
     */
    operator fun  getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    /**
     * 当给被委托属性赋值时，这个函数将被调用
     */
    operator fun  setValue(thisRef: Any?, property: KProperty<*>, s: String) {
        println(lazyValue)
        println("$s has been assigned to '${property.name} in $thisRef.'")
    }
}


fun main(args: Array<String>) {
    val e = Example()
    println(e.p)
    println("=======================")
    e.p = "张三"



}

