package com.snake.utils;

import javafx.scene.paint.Color;

import java.util.Random;

public class ColorGenerator {

    public static Color generateRandColor()
    {
        Random random = new Random();
        Color res = Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble());
        while (res == MyConstants.STAGE_COLOR) {
            System.out.println("Generated color same as background. Generating new color.");
            res = Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble());
        }
        return res;
    }
}
