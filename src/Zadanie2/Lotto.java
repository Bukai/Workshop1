package src.Zadanie2;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lotto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = 1;
        int[] couponNumbers = new int[6];

        System.out.println("Welcome to the Lotto game. Enter 6 numbers between 1-49. Good luck!");

        try {
            while (number < 7) {
                System.out.println("Give " + number + " number :");
                int playerNumber = scanner.nextInt();

                if (!cont(playerNumber, couponNumbers) && playerNumber > 0 && playerNumber <= 49) {
                    couponNumbers[number - 1] = playerNumber;
                    number++;
                } else if (playerNumber <= 0 || playerNumber > 49) {
                    System.out.println("You must enter a number between 1 and 49!");
                } else {
                    System.out.println("You have already provided this number. You must enter a different number!");
                }
            }

            Arrays.sort(couponNumbers);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Your number: " + Arrays.toString(couponNumbers));

            TimeUnit.SECONDS.sleep(2);
            System.out.println("We proceed to the draw. The block is released!");
            TimeUnit.SECONDS.sleep(2);

            int[] randomNumbers = sixRandomNumbers();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Lotto numbers drawn:");
            Arrays.sort(randomNumbers);
            System.out.println(Arrays.toString(randomNumbers));
            System.out.println(check(couponNumbers, randomNumbers));

        } catch (InterruptedException e) {
            System.out.println("Error time...");
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data!");
        }
    }

    public static int[] sixRandomNumbers() {

        int number = 0;
        Integer[] arr = new Integer[49];
        int[] tab = new int[6];

        try {

            System.out.println("We start drawing numbers: ");
            TimeUnit.SECONDS.sleep(1);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            Collections.shuffle(Arrays.asList(arr));

            for (int j = 0; j < tab.length; j++) {
                tab[j] = arr[number];
                number++;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(tab[j]);

            }

        } catch (InterruptedException e) {
            System.out.println("Error time");
        }

        return tab;
    }

    private static boolean cont(int number, int[] arr) {

        for (int value : arr) {
            if (value == number)
                return true;
        }
        return false;
    }

    private static String check(int[] playerNumber, int[] randomNumbers) {

        int winNumber = 0;

        for (int value : playerNumber) {
            if (cont(value, randomNumbers)) {
                winNumber++;
            }
        }

        switch (winNumber) {
            case 0:
                return "0 numbers hit. You lost the coupon";
            case 1:
                return "1 number hit. You lost the coupon";
            case 2:
                return "3 numbers hit. You won a coupon. Your winnings - 100$";
            case 3:
                return "4 numbers hit. You won a coupon. Your winnings - 5000$";
            case 4:
                return "5 numbers hit. You won a coupon. Your winnings - 150000$";
            case 5:
                return "6 numbers hit. You won a coupon. Your winnings - 500000$";
        }

        return "Error";
    }

}