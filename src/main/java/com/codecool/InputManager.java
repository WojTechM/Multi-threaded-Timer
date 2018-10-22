package com.codecool;

import java.util.Scanner;

class InputManager {

    static UserInput getString() {
        Scanner scanner = new Scanner(System.in);
        return new UserInput(scanner.nextLine());
    }
}
