package com.codecool;

import java.util.HashMap;
import java.util.Map;

class Application {

    private boolean isAppRunning = true;
    private Map<String, Timer> timers = new HashMap<>();
    private final InputAcquirer inputAcquirer;
    private final TimersDisplay display;

    public Application(InputAcquirer input, TimersDisplay display) {
        this.inputAcquirer = input;
        this.display = display;
    }

    void run() {
        while (isAppRunning) {
            UserInput input = inputAcquirer.getString();
            if (input.isExitRequest()) {
                exit();
            } else if (input.isStartRequest()) {
                handleStartRequest(input);
            } else if (input.isPauseRequest()) {
                handlePauseRequest(input);
            } else if (input.isDisplayRequest()) {
                handleDisplay();
            }
        }
    }

    private void handleStartRequest(UserInput input) {
        String timerName = input.getTimerName();
        if (timers.containsKey(timerName)) {
            unpauseTimer(timerName);
        } else {
            createTimer(timerName);
        }
    }

    private void handlePauseRequest(UserInput input) {
        String timerName = input.getTimerName();
        if (timers.containsKey(timerName)) {
            pauseTimer(timerName);
        } else {
            System.out.println("No such timer.");
        }
    }

    private void createTimer(String timerName) {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        timers.put(timerName, timer);
        thread.start();
    }

    private void unpauseTimer(String timerName) {
        Timer timer = timers.get(timerName);
        timer.unpause();
    }

    private void pauseTimer(String timerName) {
        Timer timer = timers.get(timerName);
        timer.pause();
    }

    private void handleDisplay() {
        display.displayTimers(timers);
    }

    private void exit() {
        isAppRunning = false;
        display.displayTimers(timers);
        for (String key : timers.keySet()) {
            Timer timer = timers.get(key);
            timer.interrupt();
        }
    }
}
