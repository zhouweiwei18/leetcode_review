package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.abs_class;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.impl.Bottle;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.mapper.Item;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.mapper.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}