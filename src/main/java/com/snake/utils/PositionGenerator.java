package com.snake.utils;
import java.awt.*;
import java.util.Random;

public class PositionGenerator {

    public static Point generateRandomPoint (int width, int height) {
        Random random = new Random();
        int posX = random.nextInt((width/10)+1)*10;
        int posY = random.nextInt((height/10)+1)*10;
        System.out.println("generateRandomPoint X: "+posX+"Y: "+posY);
        return new Point(posX,posY);
    }
}
