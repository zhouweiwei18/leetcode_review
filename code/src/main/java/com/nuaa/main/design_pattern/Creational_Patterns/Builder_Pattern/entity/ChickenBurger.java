package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.abs_class.Burger;

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}