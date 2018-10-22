package com.codecool;

public class Main {

    public static void main(String[] args) {
        InputAcquirer inputAcquirer = new InputAcquirer();
        TimersDisplay display = new TimersDisplay();
        new Application(inputAcquirer, display).run();
    }
}
