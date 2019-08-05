package com.snake.snake;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Head extends MyRectImpl {

    public Label getName() {
        return name;
    }

    private Label name;

    public Head(int x, int y, int width, int height, Color color, String inGameName) {
        super(x, y, width, height, color);
        this.name = new Label(inGameName);
        updateNamePos();
    }

    @Override
    public void setPosY(int posY)
    {
        updateNamePos();
        super.setPosY(posY);
    }

    @Override
    public void setPosX(int posX)
    {
        updateNamePos();
        super.setPosX(posX);
    }

    private void updateNamePos()
    {
        name.setLayoutX(this.getPosX()-15);
        name.setLayoutY(this.getPosY()-15);
    }

}
