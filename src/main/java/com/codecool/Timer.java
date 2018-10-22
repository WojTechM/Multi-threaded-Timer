package com.codecool;

public class Timer implements Runnable {

    private int secondsPassed = 0;
    private boolean isRunning = true;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (isRunning) {
                    Thread.sleep(1000);
                    secondsPassed++;
                    System.out.println(secondsPassed);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Timer thread interrupted.");
        }
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void toggleTimer() {
        isRunning = !isRunning;
    }
}
