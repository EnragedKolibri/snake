package com.snake.player;
import com.snake.snake.Head;
import com.snake.snake.MyRectImpl;
import com.snake.snake.Tail;
import com.snake.utils.MyConstants;
import com.sun.javafx.scene.traversal.Direction;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Player implements Runnable {

    private Direction direction;

    public Head getHead() {
        return head;
    }

    private Head head;
    private ArrayList<MyRectImpl> snakeArrayList;
    private boolean isAlive;
    private Color headColor = generateRandColor();
    private Color tailColor = generateRandColor();
    private String nane;
    private int speed;

    public Player(String name, int speed)
    {
        this.nane = name;
        this.speed = speed;
        isAlive = true;
        direction = Direction.RIGHT;
        head = new Head(10,10,10,10,headColor,name);
        snakeArrayList = new ArrayList<>();
        snakeArrayList.add(head);
        snakeArrayList.add(new Tail(tailColor,head));
        snakeArrayList.add(new Tail(tailColor,head));
        snakeArrayList.add(new Tail(tailColor,head));
    }

    public ArrayList<MyRectImpl> getSnakeArrayList() {
        return snakeArrayList;
    }

    public void changeDirection(KeyEvent e) {
        {
            switch (e.getCode().toString()) {
                case "W":
                    if (direction == Direction.DOWN)
                    {
                        break;
                    }
                    direction = Direction.UP;
                    break;
                case "A":
                    if (direction == Direction.RIGHT)
                    {
                        break;
                    }
                    direction = Direction.LEFT;
                    break;
                case "S":
                    if (direction == Direction.UP)
                    {
                        break;
                    }
                    direction = Direction.DOWN;
                    break;
                case "D":
                    if (direction == Direction.LEFT)
                    {
                        break;
                    }
                    direction = Direction.RIGHT;
                    break;
                case "F":
                    isAlive = false;
                    break;
            }
        }

    }


    @Override
    public void run() {

        do {
            System.out.println(nane+": "+"Head pos "+"X: "+snakeArrayList.get(0).getPosX()+"|Y: "+snakeArrayList.get(0).getPosX());
            for (int i = snakeArrayList.size()-1; i>0 ; i--)
            {
                snakeArrayList.get(i).setPosX(snakeArrayList.get(i-1).getPosX());
                snakeArrayList.get(i).setPosY(snakeArrayList.get(i-1).getPosY());
            }
            if (direction == Direction.UP) {
                head.setPosY(head.getPosY() - 10);
            }
            if (direction == Direction.DOWN) {
                head.setPosY(head.getPosY() + 10);
            }
            if (direction == Direction.LEFT) {
                head.setPosX(head.getPosX() - 10);
            }
            if (direction == Direction.RIGHT) {
                head.setPosX(head.getPosX() + 10);
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (isAlive);

    }

    private Color generateRandColor()
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
