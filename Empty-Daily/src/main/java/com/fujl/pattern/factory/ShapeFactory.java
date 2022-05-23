package com.fujl.pattern.factory;

public class ShapeFactory {

    public Shape getShape(String shapeType){
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
