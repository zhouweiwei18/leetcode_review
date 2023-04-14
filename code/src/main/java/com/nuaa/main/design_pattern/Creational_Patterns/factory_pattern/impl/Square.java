package com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.impl;

import com.nuaa.main.design_pattern.Creational_Patterns.factory_pattern.mapper.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
