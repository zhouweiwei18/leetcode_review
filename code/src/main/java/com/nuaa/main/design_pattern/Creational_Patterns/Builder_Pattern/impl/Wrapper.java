package com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.impl;

import com.nuaa.main.design_pattern.Creational_Patterns.Builder_Pattern.mapper.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}
