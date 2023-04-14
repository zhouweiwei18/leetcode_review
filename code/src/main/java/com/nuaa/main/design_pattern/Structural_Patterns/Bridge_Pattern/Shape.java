package com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern;

import com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern.mapper.DrawAPI;

public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}