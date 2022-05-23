package com.fujl.javabase.equals;

/**
 * == 和 equals 的区别是什么
 * == : 它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不是同 一个对象。
 * (基本数据类型== 比较的是值，引用数据类型 == 比较的是内存地址)
 * equals() : 它的作用也是判断两个对象是否相等。但它一般有两种使用情况：
 * 情况1：类没有覆盖equals() 方法。则通过 equals() 比较该类的两个对象时，等价于通过“==”比较这两个对象。
 * 情况2：类覆盖了 equals() 方法。一般，我们都覆盖 equals() 方法来两个对象 的内容相等；若它们的内
 * 容相等，则返回 true (即，认为这两个对象相等)。
 */
public class EqualsEmpty {

    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";
        if (aa == bb) {
            System.out.println("aa == bb");
        }
        if (a == b) {
            System.out.println("a == b");
        }
        if (a.equals(b)) {
            System.out.println("a.equals(b)");
        }
        if (42 == 42.0) {
            System.out.println("true");
        }
    }
}
