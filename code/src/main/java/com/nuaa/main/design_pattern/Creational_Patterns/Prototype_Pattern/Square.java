package com.nuaa.main.design_pattern.Creational_Patterns.Prototype_Pattern;

public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
