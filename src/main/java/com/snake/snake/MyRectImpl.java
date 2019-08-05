package com.snake.snake;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MyRectImpl extends Rectangle {

    private int posX;
    private int posY;

    public MyRectImpl(int x, int y, int width, int height, Color color)
    {
        this.posX = x;
        this.posY = y;
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(color);
        setX(posX);
        setY(posY);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        update();
    }

    public int getPosY() {
        return  posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        update();
    }

    private void update()
    {
        setX(posX);
        setY(posY);
    }
}
