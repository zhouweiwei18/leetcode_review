package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity.ChickenBurger;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity.Coke;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity.Pepsi;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.entity.VegBurger;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
