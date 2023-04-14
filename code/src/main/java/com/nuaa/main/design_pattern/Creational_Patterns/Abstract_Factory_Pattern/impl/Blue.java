package com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.impl;

import com.nuaa.main.design_pattern.Creational_Patterns.Abstract_Factory_Pattern.mapper.Color;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
