package src.Zadanie3;

import java.util.Scanner;

public class PcGuessNumber {

    public static void main(String[] args) {

        int min = 1;
        int max = 1000;
        int life = 10;

        boolean win = false;

        System.out.println("Think the number form " + min + " to " + max +
                " and will try to guess, which one is it! And I have only 10 chances.");
        System.out.println("If You are ready, press Enter.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        while (!win && life > 0) {
            int guess = guessNumber(min, max);

            System.out.println("I'm trying to guess the number " + guess);
            System.out.println("Is this the number?");

            if (check()) {
                System.out.println("I Win!");
                System.out.println("My life: " + life);
                win = true;
            } else {
                System.out.println("Is to big?");
                if (check()) {
                    max = guess;
                } else {
                    System.out.println("Is small?");
                    if (check()) {
                        min = guess;
                    } else {
                        System.out.println("cheating!");
                        break;
                    }
                }

                life--;
                System.out.println("My life: " + life);
            }
        }
    }

    private static boolean check() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        boolean right = false;
        boolean yes = answer.equals("Yes") || answer.equals("yes");
        boolean no = answer.equals("No") || answer.equals("no");
        while (!right) {
            if (yes) {
                return true;
            } else if (no) {
                return false;
            } else {
                System.out.println("Answer: Yes or No!");
                right = true;
            }
        }

        check();
        return right;
    }

    private static int guessNumber(int min, int max) {
        return ((max - min)) / 2 + min;
    }
}
