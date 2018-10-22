package com.codecool;

public class Timer implements Runnable {

    private int secondsPassed = 0;
    private boolean isRunning = true;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000);
                secondsPassed++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Timer thread interrupted.");
        }
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public void toggleTimer() {
        isRunning = !isRunning;
    }
}
