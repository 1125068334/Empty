package com.fujl.pattern.abstractfactory;

public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("Color::blue");
    }
}
