package com.chyngyz;

import java.util.Scanner;

/**
 * Created by Chyngyz on 12/31/2018.
 */

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + (int) min + " and " + (int) max);
        }
        return value;
    }
}
