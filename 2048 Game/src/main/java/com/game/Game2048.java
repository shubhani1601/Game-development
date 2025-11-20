package com.game;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Game2048 {

    private Board board;
    private GridPane gridUI;
    private boolean gameOver = false;

    public Game2048(Board board, GridPane gridUI) {
        this.board = board;
        this.gridUI = gridUI;
        updateUI();
    }

    public void move(Move move) {
        if (gameOver) return;

        boolean changed = board.move(move);
        updateUI();

        if (board.isGameOver()) {
            gameOver = true;
            showGameOver();
        }
    }

    private void showGameOver() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "No more moves!\n\nGame Over!", ButtonType.OK);
        alert.setHeaderText("Game Over");
        alert.showAndWait();
    }

    public void reset() {
        board = new Board();
        gameOver = false;
        updateUI();
    }

    private void updateUI() {
        gridUI.getChildren().clear();
        int[][] values = board.getGrid();

        for (int r = 0; r < 4; r++)
            for (int c = 0; c < 4; c++) {
                Label label = new Label(values[r][c] == 0 ? "" : String.valueOf(values[r][c]));
                label.setPrefSize(80, 80);
                label.setAlignment(Pos.CENTER);
                label.setStyle("-fx-background-color: #CDC1B4; -fx-border-color: #776E65;");
                label.setFont(new Font(24));
                gridUI.add(label, c, r);
            }
    }
}
