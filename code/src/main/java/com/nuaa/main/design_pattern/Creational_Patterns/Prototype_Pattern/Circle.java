package com.nuaa.main.design_pattern.Creational_Patterns.Prototype_Pattern;

public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
