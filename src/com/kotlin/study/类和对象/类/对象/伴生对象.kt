package com.kotlin.study.类和对象.类.对象

/**
 * 在类内部声明对象时，加上companion标注，就是伴生对象
 * 伴生对象内的成员就相当于Java类里面的静态成员，可以直接使用它声明所在的类对的名称直接调用
 */
class MyClass{
    //如果伴生对象声明时没有名称，那么他的默认名称就是Companion
    companion object {
        @JvmStatic
        fun create() = MyClass()
    }
}

fun main(args: Array<String>) {
    MyClass.create()
    MyClass.Companion.create()
}

interface Factory<T>{
    fun creat():T
}

/**
 * 尽管，伴生对象的成员用法上像Java中的静态成员，但运行时他们仍然真实对象的成员。和对象声明一样可以有超类
 * 在Jvm平台，如果用@JvmStatic标注伴生对象的成员，那么这些成员就称为了真正意义上的静态成员
 *
 * 对象表达式和对象声明的区别：
 * 1.对象表达式在使用它们的地方立即执行
 * 2.对象声明是在第一次被访问到时延迟初始化的
 * 3.伴生对象的初始化时相应的类 被加载时，与Java中静态初始化器语言相匹配
 */
class OterClass{
    companion object : Factory<OterClass>{
        @JvmStatic
        override fun creat(): OterClass {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}