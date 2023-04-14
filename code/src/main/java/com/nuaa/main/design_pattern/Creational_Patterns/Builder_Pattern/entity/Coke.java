package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.abs_class.ColdDrink;

public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}