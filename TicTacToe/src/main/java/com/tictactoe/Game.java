package com.tictactoe;

public class Game {
    //Initializing a 3 by 3 board for TicTacToe
    public char[][] board = new char[3][3];

    // X is user, O is the computer
    public Game() { reset(); }
    public void reset() { for (int r=0;r<3;r++) for(int c=0;c<3;c++) board[r][c]=' '; }

    public boolean play(int r, int c, char mark) {
        if (r < 0 || r > 2 || c < 0 || c > 2) return false;
        if (board[r][c] != ' ') return false;
        board[r][c] = mark;
        return true;
    }

    public boolean play(int r, int c) {
        return play(r, c, 'X');
    }

    public Character checkWin() {
        int n=3;

        //Checking horizontally and vertically
        for (int i=0;i<n;i++)
        {
            if (board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
                return board[i][0];
            if (board[0][i]!=' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i])
                return board[0][i];
        }

        //Checking diagonally
        if (board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2])
            return board[0][0];
        if (board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
            return board[0][2];

        for (int r=0;r<n;r++) for(int c=0;c<n;c++)
            if (board[r][c]==' ')
                return null;

        return 'D'; // Draw condition
    }
}
