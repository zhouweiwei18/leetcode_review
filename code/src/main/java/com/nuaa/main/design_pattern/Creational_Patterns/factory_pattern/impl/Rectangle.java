package com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.impl;

import com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.mapper.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
