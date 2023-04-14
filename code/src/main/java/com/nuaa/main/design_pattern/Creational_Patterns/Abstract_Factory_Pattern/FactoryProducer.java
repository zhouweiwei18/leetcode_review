package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.factory.AbstractFactory;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.factory.ColorFactory;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.factory.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
