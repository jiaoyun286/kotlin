package com.kotlin.study.构造函数

/**
 * Created by Administrator on 2017/8/1.
 */
class Ainimal  constructor(name: String,age: Int){

    init {
        println("构造参数分别是 name = ${name},age = ${age}")
    }

    //次构造函数必须显式的直接或间接调用主构造函数
    constructor(name: String,age: Int,weight: Float):this(name,age){
        println("构造参数分别是 name = ${name},age = ${age},weight = ${weight}")
    }
}