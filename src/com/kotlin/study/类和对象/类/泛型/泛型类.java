package com.kotlin.study.类和对象.类.泛型;

/**
 * @author JiaoYun
 * @date 2017/12/2 下午3:50
 * @Description
 *
 * 什么是泛型？
 * JavaSE 1.5的新特性，其本质是参数化类型，也就是说所操作数据的类型指定为一个参数。这种参数可以用在类、接口和方法的声明。
 * 参数化类型的理解：就是使可操作的类型参数化，就像方法的参数一样，声明时可以称为形参，使用时被称为实参。
 * 在使用时参数化类型，也要被具体的类型所替代。
 *
 * 为什么使用泛型？
 *
 * 简单来说就是：安全简单
 * 在编译时候检查类型安全，并且所有强制转换都是自动和隐式的，以提高代码的重用率
 * 举例子：
 * 集合框架提供各种集合类来作为对象的容器，而这些类的定义都是参数化的，就是不限定我们具体传入的是什么类型。
 * 但是，在使用时，我们实例集合对象时，泛型的参数类型就必须确定了，被称为实例化的参数类型，这时候集合元素的类型也就确定了，
 * 如果我们传入的集合元素的类型不符，就无法通过编译，这就是编译时检查类型安全。
 * 在从集合中取出集合元素，并使用时，也不需要做强制类型转换，因为可以推断出来，编译器为我们做了隐式的类型转换。
 *
 * 什么是泛型类？
 *
 * 为什么使用泛型类？
 *
 * 怎么使用泛型类？
 *
 *
 */
public class 泛型类<T> {

    private T mT ;

    public 泛型类(T mT) {
        this.mT = mT;
    }
}

/**
 * 不使用泛型的类
 * 能操作的只有String类型的数据
 * 就像能装苹果的盒子，就装不了香蕉。想要装香蕉，我们必须声明一个装香蕉的盒子类
 * 使用了泛型，不仅能装苹果、香蕉，其他类型也都可以装。
 *
 */
 class Box{
    private String object;

     public String getObject() {
         return object;
     }

     public void setObject(String object) {
         this.object = object;
     }

    /**
     * 泛型方法
     * 只需要在返回值前声明泛型参数列表的方法就是泛型方法，与方法声明所在的类是不是泛型类没有关系
     * @param t
     * @param <T>
     */
     public <T> void printParam(T t){
         System.out.println(t.toString());
     }
 }
