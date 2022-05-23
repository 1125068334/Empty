package com.fujl.pattern.abstractfactory;

import com.fujl.pattern.factory.Circle;
import com.fujl.pattern.factory.Rectangle;
import com.fujl.pattern.factory.Shape;
import com.fujl.pattern.factory.Square;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String colorType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if (null == shapeType) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else {
            return null;
        }
    }
}
