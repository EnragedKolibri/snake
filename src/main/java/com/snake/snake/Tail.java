package com.snake.snake;

import com.snake.player.Player;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Tail extends MyRectImpl {

    public Tail(Color color, Head head) {
        super(head.getPosX(), head.getPosY(),(int) head.getWidth(), (int) head.getHeight(), color);
    }

}
