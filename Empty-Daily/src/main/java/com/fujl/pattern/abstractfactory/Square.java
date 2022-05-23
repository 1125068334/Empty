package com.fujl.pattern.abstractfactory;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw");
    }
}
