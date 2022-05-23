package com.fujl.pattern.abstractfactory;

public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Color::red");
    }
}
