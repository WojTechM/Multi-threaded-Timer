package com.codecool;

import java.util.Scanner;

class InputAcquirer {

    UserInput getString() {
        Scanner scanner = new Scanner(System.in);
        return new UserInput(scanner.nextLine());
    }
}
