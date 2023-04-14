package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.abs_class.Burger;

public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}