package com.fujl.javabase.classtype;

/**
 * 内部类分类： 成员内部类、局部内部类、匿名内部类和静态内部类
 * 内部类的优点：
 *  一个内部类对象可以访问创建它的外部类对象的内容，包括私有数据！
 *  内部类不为同一包的其他类所见，具有很好的封装性；
 *  内部类有效实现了“多重继承”，优化 java 单继承的缺陷。
 *  匿名内部类可以很方便的定义回调。
 * 内部类有哪些应用场景
 * 1. 一些多算法场合
 * 2. 解决一些非面向对象的语句块。
 * 3. 适当使用内部类，使得代码更加灵活和富有扩展性。
 * 4. 当某个类除了它的外部类，不再被其他的类使用时。
 */
public class Outer {

    private static int radius = 1;

    private int count = 2;

    private int out_a = 1;

    private static int STATIC_b = 2;

    /**
     * 静态内部类: 定义在类内部的静态类，就是静态内部类
     * 静态内部类可以访问外部类所有的静态变量，而不可访问外部类的非静态变量； 静态内部类的创建方
     * 式，new 外部类.静态内部类()
     */
    static class StaticInner{
        public void visit(){
            System.out.println("visit outer static variable:" + radius);
        }
    }

    /**
     * 成员内部类: 定义在类内部，成员位置上的非静态类，就是成员内部类
     * 成员内部类可以访问外部类所有的变量和方法，包括静态和非静态，私有和公 有。成员内部类依赖于外
     * 部类的实例，它的创建方式外部类实例.new 内部类()
     */
    class Inner{
        public void visit(){
            System.out.println("visit outer static variable:" + radius);
            System.out.println("visit outer variable:" + count);
        }
    }

    /**
     * 局部内部类1: 定义在方法中的内部类，就是局部内部类
     * 定义在实例方法中的局部类可以访问外部类的所有变量和方法，定义在静态方法 中的局部类只能访问外
     * 部类的静态变量和方法。局部内部类的创建方式，在对应 方法内，new 内部类()
     */
    public void testFunctionClass(){
        int inner_c = 3;
        class Inner{
            private void fun(){
                System.out.println(out_a);
                System.out.println(STATIC_b);
                System.out.println(inner_c);
            }
        }
        Inner inner = new Inner();
        inner.fun();
    }

    /**
     * 局部内部类2
     */
    public static void testStaticFunctionClass(){
        int d = 3;
        class Inner{
            private void fun(){
//                System.out.println(out_a);// 编译错误，定义在静态方法中的局部类不可以访问外 部类的实例变量
                System.out.println(STATIC_b);
                System.out.println(d);
            }
        }
        Inner inner = new Inner();
        inner.fun();
    }

    /**
     * 匿名内部类: 没有名字的内部类，日常开发中使用的比较多
     * 特点：
     *  匿名内部类必须继承一个抽象类或者实现一个接口。
     *  匿名内部类不能定义任何静态成员和静态方法。
     *  当所在的方法的形参需要被匿名内部类使用时，必须声明为 final。
     *  匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方 法。
     */
    private void test(final int i) {
        new Service() {
            @Override
            public void method() {
                for (int j = 0; j < i; j++) {
                    System.out.println("匿名内部类");
                }
            }
        }.method();//匿名内部类必须继承或实现一个已有的接口
    }
    interface Service{
        void method();
    }


    public static void main(String[] args) {
//        StaticInner staticInner = new StaticInner();
//        staticInner.visit();
//
        Outer outer = new Outer();
//        Inner inner = outer.new Inner();
//        inner.visit();

        outer.testFunctionClass();
        testStaticFunctionClass();
    }
}
