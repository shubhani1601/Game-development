package com.game;

import java.util.*;

public class QLearningAgent {

    private Map<String, Map<Move, Double>> qTable = new HashMap<>();
    private double alpha = 0.2;  // learning rate
    private double gamma = 0.9;  // discount factor
    private double epsilon = 0.2; // exploration

    public Move selectMove(String state) {
        if (!qTable.containsKey(state)) qTable.put(state, initMoves());

        if (Math.random() < epsilon) {
            return Move.values()[new Random().nextInt(4)];
        }

        return qTable.get(state).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public void update(String oldState, Move move, String newState, double reward) {
        qTable.putIfAbsent(oldState, initMoves());
        qTable.putIfAbsent(newState, initMoves());

        double oldValue = qTable.get(oldState).get(move);
        double nextMax = Collections.max(qTable.get(newState).values());

        double newValue = oldValue + alpha * (reward + gamma * nextMax - oldValue);

        qTable.get(oldState).put(move, newValue);
    }

    private Map<Move, Double> initMoves() {
        Map<Move, Double> map = new HashMap<>();
        for (Move m : Move.values()) map.put(m, 0.0);
        return map;
    }
}
