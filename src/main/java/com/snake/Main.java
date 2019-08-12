package com.snake;

import com.snake.core.Core;
import com.snake.food.Food;
import com.snake.player.Player;
import com.snake.utils.ColorGenerator;
import com.snake.utils.MyConstants;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.text.html.ImageView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


public class Main extends Application {

    private int width = 500;
    private int height = 500;
    private Core core;

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage stage) throws Exception {
        HashMap<String, Player> players = new HashMap<>();
        core = new Core();
        Group root = new Group();
        core.getPlayers().forEach( (s, player) -> player.getSnakeArrayList().forEach(e->root.getChildren().add(e)));
        root.getChildren().add(core.getPlayers().get("Player1").getHead().getName());
        Scene scene = new Scene(root, width, height, MyConstants.STAGE_COLOR);
        stage.setTitle("Vision");
        stage.setScene(scene);
        stage.setWidth(width);
        stage.setHeight(height);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEventEventHandler);
        stage.show();


        Thread threadCore = new Thread(core);
        threadCore.start();
        root.getChildren().add(core.spawnFood(width,height));


    }

    private EventHandler<KeyEvent> keyEventEventHandler = e -> {

            core.getPlayers().get("Player1").changeDirection(e);

        System.out.println(e.getCode().toString());
    };

}
