package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
