package org.crypto.user;

import java.util.Scanner;

public class Input {

    public static String getUserInput(String inputMessage) {
        System.out.println(inputMessage);
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }
}
