package com.fujl.pattern.prototype;

import java.util.Hashtable;
import java.util.Map;

public class ShapeCache {

    private static Map<String, Shape> map = new Hashtable<>();

    public static Shape getShape(String shapeId){
        Shape shapeCache = map.get(shapeId);
        return (Shape) shapeCache.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        map.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        map.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        map.put(rectangle.getId(),rectangle);

    }


}
