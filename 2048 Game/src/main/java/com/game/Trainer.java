package com.game;

public class Trainer {

    private QLearningAgent agent;

    public Trainer(QLearningAgent agent) {
        this.agent = agent;
    }

    public void train(int episodes) {
        System.out.println("Training...");
        for (int i = 0; i < episodes; i++) {
            Board b = new Board();
            while (!b.isGameOver()) {
                String state = StateEncoder.encode(b.getGrid());
                Move move = agent.selectMove(state);
                boolean changed = b.move(move);
                double reward = changed ? score(b) : -5;
                String newState = StateEncoder.encode(b.getGrid());
                agent.update(state, move, newState, reward);
            }
            if (i % 100 == 0) System.out.println("Episode: " + i);
        }
        System.out.println("Training Completed");
    }

    private int score(Board b) {
        int score = 0;
        for (int[] row : b.getGrid())
            for (int val : row)
                score += val;
        return score;
    }
}
