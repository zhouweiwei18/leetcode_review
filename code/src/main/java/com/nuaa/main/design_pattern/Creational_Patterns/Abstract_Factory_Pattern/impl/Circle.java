package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl;


import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
