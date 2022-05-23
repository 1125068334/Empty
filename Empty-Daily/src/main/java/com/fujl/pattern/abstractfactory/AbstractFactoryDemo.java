package com.fujl.pattern.abstractfactory;

import com.fujl.pattern.factory.Shape;

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        assert colorFactory != null;
        Color red = colorFactory.getColor("green");
        red.fill();

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        assert shapeFactory != null;
        Shape square = shapeFactory.getShape("square");
        square.draw();

    }
}
