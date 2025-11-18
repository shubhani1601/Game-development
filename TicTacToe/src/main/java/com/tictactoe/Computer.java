package com.tictactoe;

public class Computer {
    public int[] bestMove(Game g) {
        int bestScore = Integer.MIN_VALUE;
        int[] best = null;
        for (int r=0;r<3;r++) for (int c=0;c<3;c++) {
            if (g.board[r][c]==' ') {
                g.board[r][c]='O';
                int score = minimax(g, false);
                g.board[r][c]=' ';
                if (score > bestScore) { bestScore = score; best = new int[]{r,c}; }
            }
        }
        return best;
    }

    private int minimax(Game game, boolean isMax) {
        Character result = game.checkWin();
        if (result != null) {
            if (result == 'O') return 1;
            if (result == 'X') return -1;
            return 0; // Draw condition, score 0
        }
        int best = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int r=0;r<3;r++) for (int c=0;c<3;c++) {
            if (game.board[r][c]==' ') {
                game.board[r][c] = isMax ? 'O' : 'X';
                int val = minimax(game, !isMax);
                game.board[r][c] = ' ';
                if (isMax) best = Math.max(best, val); else best = Math.min(best, val);
            }
        }
        return best;
    }
}
