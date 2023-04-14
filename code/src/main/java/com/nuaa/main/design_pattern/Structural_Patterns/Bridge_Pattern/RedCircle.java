package com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern;

import com.nuaa.main.design_pattern.Structural_Patterns.Bridge_Pattern.mapper.DrawAPI;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
