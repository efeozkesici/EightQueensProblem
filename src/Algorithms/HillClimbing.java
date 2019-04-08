package Algorithms;

import java.util.concurrent.TimeUnit;

import Model.ProblemSolver;

public class HillClimbing {
    private Queens queens;
    private double currentValue;
    private int moveCount;
    private int randomRestartCount;
    private double processTime;

    public void init() {
        this.queens = new Queens();
    }

    public void runHillClimbing(ProblemSolver problemSolver) {
        this.moveCount = 0;
        this.randomRestartCount = 0;
        this.processTime = 0;

        long start = System.nanoTime();
        this.currentValue = this.queens.initialState();

        while (true) {
            double bestSuccessorValue = this.queens.generateBestSuccessor();

            if (bestSuccessorValue < this.currentValue) {
                this.queens.acceptSuccessor();
                this.currentValue = bestSuccessorValue;
                this.moveCount++;

                if (this.currentValue == 0) {
                    long end = System.nanoTime();
                    this.processTime = TimeUnit.NANOSECONDS.toMillis(end - start);
                    return;
                }
            } else {
                this.currentValue = this.queens.generateRandomPositions();
                this.randomRestartCount++;
            }
        }
    }

    public int[] getCurrentPositions() {
        return this.queens.getCurrentPositions();
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public int getRandomRestartCount() {
        return this.randomRestartCount;
    }

    public double getProcessTime() {
        return this.processTime;
    }
}
