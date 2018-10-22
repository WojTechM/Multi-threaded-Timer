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

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void pause() {
        isRunning = false;
    }

    public void unpause() {
        isRunning = true;
    }

    public long getId() {
        return Thread.currentThread().getId();
    }

    public void interrupt() {
        thread.interrupt();
    }
}
