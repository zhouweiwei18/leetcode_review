package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Color;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
