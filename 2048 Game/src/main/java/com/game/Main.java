package com.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Board board = new Board();
        GridPane grid = new GridPane();
        Game2048 game = new Game2048(board, grid);

        Scene scene = new Scene(grid, 350, 350);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> game.move(Move.UP);
                case DOWN -> game.move(Move.DOWN);
                case LEFT -> game.move(Move.LEFT);
                case RIGHT -> game.move(Move.RIGHT);
                case R -> game.reset(); // ⬅ NEW restart shortcut
            }
        });

        stage.setTitle("2048 AI + JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
