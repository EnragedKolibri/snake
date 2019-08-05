package com.snake;

import com.snake.player.Player;
import com.snake.utils.MyConstants;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.text.html.ImageView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


public class Main extends Application {

    private int width = 500;
    private int height = 500;
    private HashMap<String,Player> players;

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage stage) throws Exception {
        players = new HashMap<>();
        players.put("Player1",new Player("Player1",50));
        Group root = new Group();
        players.forEach( (s, player) -> player.getSnakeArrayList().forEach(e->root.getChildren().add(e)));
        root.getChildren().add(players.get("Player1").getHead().getName());
        Scene scene = new Scene(root, width, height, MyConstants.STAGE_COLOR);
        stage.setTitle("Vision");
        stage.setScene(scene);
        stage.setWidth(width);
        stage.setHeight(height);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEventEventHandler);
        stage.show();

        Thread thread = new Thread(players.get("Player1"));
        thread.start();
    }

    private void spawnFood(){

    }

    private EventHandler<KeyEvent> keyEventEventHandler = e -> {

            players.get("Player1").changeDirection(e);

        System.out.println(e.getCode().toString());
    };

}
