package com.connect4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int CELL_SIZE = 80;

    private Disc[][] board = new Disc[ROWS][COLS];
    private boolean playerRedTurn = true;

    private GridPane gridPane = new GridPane();

    @Override
    public void start(Stage stage) {
        drawBoard();

        Scene scene = new Scene(gridPane, COLS * CELL_SIZE, ROWS * CELL_SIZE);
        stage.setTitle("Connect 4 - Player vs AI");
        stage.setScene(scene);
        stage.show();
    }

    private void drawBoard() {
        gridPane.getChildren().clear();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Circle circle = new Circle(CELL_SIZE / 2 - 5);
                circle.setFill(Color.LIGHTGRAY);
                circle.setStroke(Color.BLACK);

                if (board[row][col] != null) {
                    circle.setFill(board[row][col] == Disc.RED ? Color.RED : Color.YELLOW);
                }

                final int clickedCol = col;
                circle.setOnMouseClicked(e -> handleClick(clickedCol));

                gridPane.add(circle, col, row);
            }
        }
    }

    private void handleClick(int col) {
        int row = getAvailableRow(col);
        if (row == -1) return; // Column full

        board[row][col] = playerRedTurn ? Disc.RED : Disc.YELLOW;
        drawBoard();

        if (checkWin(row, col)) {
            showWinAlert(playerRedTurn ? "Red" : "Yellow");
            resetBoard();
            return;
        }

        if (isBoardFull()) {
            showDrawAlert();
            resetBoard();
            return;
        }

        playerRedTurn = !playerRedTurn;

        if (!playerRedTurn) {
            aiMove();
        }
    }

    private void aiMove() {
        // Simple AI: pick random valid column
        int col;
        do {
            col = (int) (Math.random() * COLS);
        } while (getAvailableRow(col) == -1);

        int row = getAvailableRow(col);
        board[row][col] = Disc.YELLOW;
        drawBoard();

        if (checkWin(row, col)) {
            showWinAlert("Yellow (AI)");
            resetBoard();
            return;
        }

        if (isBoardFull()) {
            showDrawAlert();
            resetBoard();
            return;
        }

        playerRedTurn = true;
    }

    private int getAvailableRow(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == null) return row;
        }
        return -1; // Column full
    }

    private boolean checkWin(int row, int col) {
        Disc disc = board[row][col];
        return checkDirection(row, col, 1, 0, disc)  // vertical
                || checkDirection(row, col, 0, 1, disc)  // horizontal
                || checkDirection(row, col, 1, 1, disc)  // diagonal /
                || checkDirection(row, col, 1, -1, disc); // diagonal \
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol, Disc disc) {
        int count = 1;

        // forward
        int r = row + dRow, c = col + dCol;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c] == disc) {
            count++;
            r += dRow;
            c += dCol;
        }

        // backward
        r = row - dRow;
        c = col - dCol;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c] == disc) {
            count++;
            r -= dRow;
            c -= dCol;
        }

        return count >= 4;
    }

    private boolean isBoardFull() {
        for (int c = 0; c < COLS; c++) {
            if (getAvailableRow(c) != -1) return false;
        }
        return true;
    }

    private void showWinAlert(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(winner + " Wins!");
        alert.showAndWait();
    }

    private void showDrawAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Draw!");
        alert.showAndWait();
    }

    private void resetBoard() {
        board = new Disc[ROWS][COLS];
        playerRedTurn = true;
        drawBoard();
    }

    enum Disc { RED, YELLOW }

    public static void main(String[] args) {
        launch();
    }
}
