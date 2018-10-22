package com.codecool;

class Application {

    private boolean isAppRunning = true;

    void run() {
        while (isAppRunning) {
            UserInput input = InputManager.getString();
            if (input.isExitRequest()) {
                exit();
            }
        }
    }

    private void exit() {
        isAppRunning = false;
    }
}
