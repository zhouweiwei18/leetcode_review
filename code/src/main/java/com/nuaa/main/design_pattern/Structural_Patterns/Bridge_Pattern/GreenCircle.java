package com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern;

import com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern.mapper.DrawAPI;

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
