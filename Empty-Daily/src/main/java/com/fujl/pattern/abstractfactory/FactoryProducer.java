package com.fujl.pattern.abstractfactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Color")) {
            return new ColorFactory();
        } else if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        }
        return null;
    }
}
