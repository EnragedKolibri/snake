package com.snake.core;

import com.snake.food.Food;
import com.snake.player.Player;
import com.snake.utils.PositionGenerator;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Core implements Runnable {

    private HashMap<String, Player> playersList;
    private HashMap<String, Thread> playersThreads;

    public Core(HashMap<String, Player> playersList) {
        this.playersList = playersList;
        playersThreads = new HashMap<>();
        playersList.forEach((string, player)-> playersThreads.put(string,new Thread(player)));
    }

    @Override
    public void run() {
        playersThreads.forEach((string, thread)-> thread.start());
    }

    public Food spawnFood(int width, int height) {
        Point foodPoint = PositionGenerator.generateRandomPoint(width,height);
        Food food= new Food(foodPoint.x,foodPoint.y,10,10, Color.RED);
        System.out.println("Food X: "+foodPoint.x+" | Y: "+foodPoint.y);
        return food;
    }

}
