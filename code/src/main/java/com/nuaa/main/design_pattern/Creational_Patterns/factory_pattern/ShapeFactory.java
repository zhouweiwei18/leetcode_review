package com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern;

import com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.impl.Rectangle;
import com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.mapper.Shape;
import com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.impl.Circle;
import com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.impl.Square;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

}
