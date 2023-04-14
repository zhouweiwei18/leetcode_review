package com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern;

import com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern.mapper.DrawAPI;

public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}