package com.tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private final Game game = new Game();
    private final Computer computer = new Computer();

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPrefSize(300, 300);
        grid.setGridLinesVisible(true);

        Button[][] cells = new Button[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                Button b = new Button("");
                b.setFont(Font.font(36));
                b.setPrefSize(100, 100);
                final int rr = r, cc = c;
                b.setOnAction(e -> {
                    // User move - 'X'
                    if (!game.play(rr, cc, 'X')) return;
                    b.setText(String.valueOf(game.board[rr][cc]));

                    Character winner = game.checkWin();
                    if (winner != null) {
                        showResult(stage, winner, grid);
                        return;
                    }

                    // Comp move - 'O'
                    int[] m = computer.bestMove(game);
                    if (m != null) {
                        boolean placed = game.play(m[0], m[1], 'O');
                        if (placed) {
                            cells[m[0]][m[1]].setText(String.valueOf(game.board[m[0]][m[1]]));
                        }
                        winner = game.checkWin();
                        if (winner != null) {
                            showResult(stage, winner, grid);
                        }
                    }
                });
                cells[r][c] = b;
                grid.add(b, c, r);
            }
        }

        VBox root = new VBox(10, grid);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 340, 380);
        stage.setScene(scene);
        stage.setTitle("Tic-Tac-Toe");
        stage.show();
    }

    private void showResult(Stage stage, Character winner, GridPane board) {
        String msg = winner == 'D' ? "Draw!" : (winner + " wins!");
        Stage dialog = new Stage();
        VBox v = new VBox(10);
        v.setAlignment(Pos.CENTER);
        Text t = new Text(msg);
        t.setFont(Font.font(20));
        Button r = new Button("Restart Game?");
        r.setOnAction(e -> {
            game.reset();
            board.getChildren().forEach(node -> {
                if (node instanceof Button) ((Button) node).setText("");
            });
            dialog.close();
        });
        v.getChildren().addAll(t, r);
        Scene s = new Scene(v, 200, 120);
        dialog.setScene(s);
        dialog.initOwner(stage);
        dialog.show();
    }

    public static void main(String[] args) { launch(); }
}
