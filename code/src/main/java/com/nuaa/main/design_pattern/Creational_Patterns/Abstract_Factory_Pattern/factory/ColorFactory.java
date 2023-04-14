package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.factory;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl.Blue;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl.Green;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl.Red;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Color;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}
