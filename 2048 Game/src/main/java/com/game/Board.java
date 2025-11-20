package com.game;

import java.util.*;

public class Board {
    private final int size = 4;
    private int[][] grid = new int[size][size];
    private Random random = new Random();

    public Board() {
        spawnTile();
        spawnTile();
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean move(Move move) {
        int[][] old = copyGrid();
        switch (move) {
            case LEFT -> slideLeft();
            case RIGHT -> {
                reverse();
                slideLeft();
                reverse();
            }
            case UP -> {
                transpose();
                slideLeft();
                transpose();
            }
            case DOWN -> {
                transpose();
                reverse();
                slideLeft();
                reverse();
                transpose();
            }
        }
        boolean changed = !Arrays.deepEquals(old, grid);
        if (changed) spawnTile();
        return changed;
    }

    private void slideLeft() {
        for (int i = 0; i < size; i++) {
            int[] row = Arrays.stream(grid[i]).filter(x -> x != 0).toArray();
            List<Integer> merged = new ArrayList<>();
            for (int j = 0; j < row.length; j++) {
                if (j < row.length - 1 && row[j] == row[j + 1]) {
                    merged.add(row[j] * 2);
                    j++;
                } else merged.add(row[j]);
            }
            while (merged.size() < size) merged.add(0);
            grid[i] = merged.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    private void spawnTile() {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == 0) empty.add(new int[]{i, j});

        if (!empty.isEmpty()) {
            int[] pos = empty.get(random.nextInt(empty.size()));
            grid[pos[0]][pos[1]] = random.nextDouble() < 0.9 ? 2 : 4;
        }
    }

    private void transpose() {
        int[][] newGrid = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                newGrid[i][j] = grid[j][i];
        grid = newGrid;
    }

    private void reverse() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size / 2; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i][size - j - 1];
                grid[i][size - j - 1] = temp;
            }
    }

    public boolean isGameOver() {
        for (Move m : Move.values())
            if (canMove(m)) return false;
        return true;
    }

    private boolean canMove(Move move) {
        Board temp = new Board();
        temp.grid = copyGrid();
        return temp.move(move);
    }

    private int[][] copyGrid() {
        return Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
    }
}
