package src.Zadanie1;

import java.util.Random;
import java.util.Scanner;

public class PlayerGuessNumber {

    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        System.out.println("The number (1 - 100) has been drawn! Guess the number?");

        int number = loadedNumber();
        int chances = 5;

        while (number != randomNumber) {
            if (number > randomNumber) {
                System.out.println("Your number is too big!");
                chances--;
                System.out.println("Your Chances: " + chances);
            } else {
                System.out.println("Your number is too Small!");
                chances--;
                System.out.println("Your Chances: " + chances);
            }

            if (chances == 0) {
                System.out.println("Lost game!");
                break;
            } else {
                number = loadedNumber();
            }
        }

        if (number == randomNumber) {
            System.out.println("Congratulations! You guessed the number");
        }

    }

    public static int loadedNumber() {
        System.out.println("Give me a number: ");

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("You must enter a number!");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
