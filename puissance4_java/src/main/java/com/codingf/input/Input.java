package com.codingf.input;

import java.util.Scanner;

public class Input {
    // static methodes

    public static int readInt(Scanner scan){

        String input = scan.nextLine();
        int result = -1;

        try {
            result =Integer.parseInt(input);
        }catch (NumberFormatException e){

        }
        return result;
    }
}
