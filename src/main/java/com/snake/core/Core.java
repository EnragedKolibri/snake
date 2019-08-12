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

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    private HashMap<String, Player> players;
    private HashMap<String, Thread> playersThreads;

    public Core() {
        players = new HashMap<>();
        players.put("Player1",new Player("Player1",100));
        playersThreads = new HashMap<>();
        players.forEach((string, player)-> playersThreads.put(string,new Thread(player)));
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
