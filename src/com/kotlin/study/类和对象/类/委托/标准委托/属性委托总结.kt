package com.kotlin.study.类和对象.类.委托.标准委托

import com.kotlin.study.类和对象.类.委托.Delegate

/**
 * 在每个委托属性的实现背后，编译器都会为它生成一个辅助属性并委托给它
 * 可以看到下面注释掉的例子中：
 * 委托属性的get()和set()方法，实际上是委托给了背后生成的委托类实例的getValue()和setValue()方法去处理了
 * 其中参数：
 * this 引用声明所在类的实例，包基本和局部变量委托属性为null
 * this::prop 是KProperty 类型的反射对象,该对象描述属性自身
 */
class C{
//    var prop by Delegate()

    //下面是编译器编译后的代码

//    class C {
//        private val prop$delegate = MyDelegate()
//        var prop: Type
//            get() = prop$delegate.getValue(this, this::prop)
//        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
//    }

}