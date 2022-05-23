package com.fujl.javabase;

import java.util.Arrays;

/**
 * 方法的参数传递机制
 * 栈 存储局部变量表(编译期可知的各种Java虚拟机基本数据类型、对象引用)、操作数栈、动态连接、方法出口等信息
 * 堆  对象实例
 * 常量池 存放编译期生成的各种字面量与符号引用
 *
 * 结论：
 *  形参是基本数据类型--传递数据值
 *  实参是引用数据类型--1. 传递地址值； 2. 特殊的类型: String、包装类等对象不可变性
 */
public class MethodParam {

    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3};
        MyData my = new MyData();

        change(i, str, num, arr, my);// 实参列表

        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("my.a = " + my.a);
    }

    public static void change(int j, String s, Integer n, int[] a, MyData m) {// 形参列表
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData{
    int a = 10;
}
