package com.practice.in.Serialization_Deserialization;

import java.util.Scanner;


public class ScannerReadingConsole {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter inputs (type 'exit' to quit):");

            while (true) {
                System.out.print("Enter a word: ");
                if (!sc.hasNext()) break;
                String word = sc.next();
                if (word.equalsIgnoreCase("exit")) break;

                // Clear the newline after next() before using nextLine()
                sc.nextLine();

                System.out.print("Enter a full line: ");
                String line = sc.nextLine();

                System.out.print("Enter an integer: ");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a valid integer. Try again:");
                    sc.next(); // consume the invalid token
                }
                int number = sc.nextInt();

                // Clear newline after nextInt() before next iteration
                sc.nextLine();

                System.out.println("You entered:");
                System.out.println("Word: " + word);
                System.out.println("Line: " + line);
                System.out.println("Integer: " + number);
            }
        }
        System.out.println("Program ended.");
    }
}
