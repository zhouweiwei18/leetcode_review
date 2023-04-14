package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.abs_class;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.mapper.Item;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.mapper.Packing;
import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.impl.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
