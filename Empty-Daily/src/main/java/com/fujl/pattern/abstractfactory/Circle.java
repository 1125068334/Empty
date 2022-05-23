package com.fujl.pattern.abstractfactory;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw");
    }
}
