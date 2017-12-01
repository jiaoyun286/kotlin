package com.kotlin.study.扩展

/**
 * 扩展的作用域：
 * 大多数时候我们定义扩展在包的级别，所以要使用包定义之外的扩展，只需要导入扩展所在包就可以了（连同扩展的名称）
 */

/**
 * 伴生对象的扩展
 */
class MyClass {
    companion object {//伴生对象没有命名，默认为"Companion"

    }
}
fun MyClass.Companion.foo(){

}

/**
 * 扩展声明在成员位置
 * 扩展可以声明在一个类内部，这样就有两个隐式的接收者，扩展声明所在的类实例为分发接收者，扩展方法调用所在的接收者类型的实例为扩展接收者。
 * 无论哪个接收者的成员，在扩展方法内都可以直接访问，而不用任何限定符
 *
 * 注意：
 * 若干扩展接收者和扩展分发者有同名成员，默认调用的是扩展接收者的成员，要调用扩展分发者的成员，需要用this语法：
 * this@扩展分发者类名.成员
 *
 *
 */
open class ClassA {
    fun bar(){}
}

class ClassA1: ClassA(){

}
open class ClassB {
    fun baz(){

    }
    fun ClassA.foo(){
        bar() //扩展接收者的方法
        baz() //分发接收者的方法

        toString()
        this@ClassB.toString()  //调用扩展分发者的方法

    }

    open fun ClassA.fooA(){
        println("classB  ClassA fooA")
    }

    open fun ClassA1.fooA(){
        println("classB  ClassA1 fooA")
    }

    fun caller(a: ClassA){
        a.fooA()
    }
}

/**
 * 声明为成员的扩展可以声明为 open 并在子类中覆盖。这意味着这些函数的分发 对于分发接收者类型是虚拟的，但对于扩展接收者类型是静态的。
 * 也就是，如果在基类中声明的扩展，在子类中被覆盖了，如果用子类对象调用到的扩展是被覆盖了的。扩展对于分发接收者是动态绑定的虚方法。对于扩展接收者是静态解析的
 */
class ClassB1: ClassB(){
    override fun ClassA.fooA(){
        println("classB1 ClassA fooA")
    }
    override fun ClassA1.fooA(){
        println("classB1 ClassA1 fooA")
    }

}



fun main(args: Array<String>) {
    MyClass.foo()//伴生对象扩展的调用和普通成员一样
    ClassB().caller(ClassA())
    ClassB1().caller(ClassA())
    ClassB().caller(ClassA1())
}


