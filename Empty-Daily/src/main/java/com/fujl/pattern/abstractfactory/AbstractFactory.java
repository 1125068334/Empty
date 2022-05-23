package com.fujl.pattern.abstractfactory;

import com.fujl.pattern.factory.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);
    public abstract Shape getShape(String shapeType);
}
