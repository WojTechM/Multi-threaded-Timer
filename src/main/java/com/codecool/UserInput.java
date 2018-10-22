package com.codecool;

class UserInput {

    private final String input;

    UserInput(String input) {
        this.input = input;
    }

    boolean isExitRequest() {
        return input.equalsIgnoreCase("exit");
    }

    boolean isStartRequest() {
        return input.toLowerCase().startsWith("start");
    }

    String getTimerName() {
        return input.split(" ")[1];
    }
}
