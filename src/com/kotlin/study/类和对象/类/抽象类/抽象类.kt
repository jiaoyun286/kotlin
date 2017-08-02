package com.kotlin.study.类和对象.类.抽象类

open class 非抽象类 {
    open fun f(){

    }
}

abstract class 抽象类 : 非抽象类(){

   abstract override fun f()

}