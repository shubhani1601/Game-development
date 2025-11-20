package com.game;
import java.util.Arrays;

public class StateEncoder {
    public static String encode(int[][] grid) {
        return Arrays.deepToString(grid);
    }
}
