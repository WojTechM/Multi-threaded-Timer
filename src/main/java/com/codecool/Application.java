package com.codecool;

import java.util.HashMap;
import java.util.Map;

class Application {

    private boolean isAppRunning = true;
    private Map<String, Timer> timers = new HashMap<>();

    void run() {
        while (isAppRunning) {
            UserInput input = InputManager.getString();
            if (input.isExitRequest()) {
                exit();
            } else if (input.isStartRequest()) {
                handleStartRequest(input);
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

    private void createTimer(String timerName) {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        timers.put(timerName, timer);
        thread.start();
    }

    private void unpauseTimer(String timerName) {
        Timer timer = timers.get(timerName);
        if (!timer.isRunning()) {
            timer.toggleTimer();
        }
    }

    private void exit() {
        isAppRunning = false;
    }
}
