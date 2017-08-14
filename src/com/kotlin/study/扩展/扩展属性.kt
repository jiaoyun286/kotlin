package com.kotlin.study.扩展

/**
 * 扩展属性和扩展函数类似
 * 注意：
 * 由于扩展属性并未真正的将成员插入类中，因此扩展属性并没有幕后字段，所以扩展属性不能有初始化器。只能显式的提供getters/setters
 */
val <T> List<T>.lastIndex: Int
get() = size - 1

