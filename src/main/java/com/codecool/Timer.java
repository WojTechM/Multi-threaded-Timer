package com.codecool;

public class Timer implements Runnable {

    private int secondsPassed = 0;
    private boolean isRunning = true;
    private Thread thread;

    @Override
    public void run() {
        try {
            thread = Thread.currentThread();
            while (!thread.isInterrupted()) {
                if (isRunning) {
                    Thread.sleep(1000);
                    secondsPassed++;
                }
            }
        } catch (InterruptedException e) {
            // Thread stopped
        }
    }

    int getSecondsPassed() {
        return secondsPassed;
    }

    void pause() {
        isRunning = false;
    }

    void unpause() {
        isRunning = true;
    }

    long getId() {
        return thread.getId();
    }

    void interrupt() {
        thread.interrupt();
    }
}
