package com.snake.food;

import com.snake.player.Player;
import com.snake.snake.MyRectImpl;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Food extends MyRectImpl {
    public Food(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
}
