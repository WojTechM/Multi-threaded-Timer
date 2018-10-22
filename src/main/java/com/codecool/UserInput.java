package com.codecool;

class UserInput {

    private final String input;

    UserInput(String input) {
        this.input = input;
    }

    boolean isExitRequest() {
        return input.equalsIgnoreCase("exit");
    }
}
