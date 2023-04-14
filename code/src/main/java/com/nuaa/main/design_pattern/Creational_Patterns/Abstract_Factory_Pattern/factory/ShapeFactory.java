package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.factory;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl.Circle;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl.Rectangle;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl.Square;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Color;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Shape;


public class ShapeFactory extends AbstractFactory {

    @Override
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

    public Color getColor(String color) {
        return null;
    }
}
