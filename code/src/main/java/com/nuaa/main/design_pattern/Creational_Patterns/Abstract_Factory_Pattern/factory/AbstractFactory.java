package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.factory;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Color;
import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
