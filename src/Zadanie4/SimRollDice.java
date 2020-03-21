package src.Zadanie4;

import java.lang.ref.PhantomReference;
import java.util.Random;
import java.util.Scanner;

public class SimRollDice {

    public static void main(String[] args) {

        try {
            System.out.println("Simulator roll of the dice");
            System.out.println("Enter how many times you roll the dice");
            Scanner scan = new Scanner(System.in);
            String x = scan.nextLine();

            System.out.println("how many wall dice to play? ");
            String y = "D" + scan.nextLine();

            System.out.println("enter the modifier: ");
            String z = scan.nextLine();

            String rollDice = x + y;

            if (Integer.parseInt(z) >= 0) {
                rollDice = rollDice + "+" + z;
            } else {
                rollDice = rollDice + "-" + z;
            }

            System.out.println("Type of dice: " + rollDice);

            System.out.println("The result is " + rollXYZ(rollDice));
        } catch (NumberFormatException e) {
            System.out.println("Invalid data provided. Only numbers can be entered!");
        }
    }

    public static int rollXYZ(String disc) {
        int x = rollX(disc);
        int y = rollY(disc);
        int z = rollZ(disc);

        return generateNumber(x, y, z);

    }

    private static int rollX(String xStr) {
        int xIndex = xStr.indexOf("D");
        xStr = xStr.substring(0, xIndex);
        if (xStr.equals("")) {
            return 1;
        } else {
            return Integer.parseInt(xStr);
        }
    }

    private static int rollY(String y) {
        int xIndex = y.indexOf("D");
        if (y.contains("+")) {
            int yIndex = y.indexOf("+");
            String yStr = y.substring(xIndex + 1, yIndex);
            return Integer.parseInt(yStr);

        } else if (y.contains("-")) {
            int yIndex = y.indexOf("-");
            String yStr = y.substring(xIndex + 1, yIndex);
            return Integer.parseInt(yStr);
        } else {
            return Integer.parseInt(y);
        }
    }

    private static int rollZ(String z) {
        if (z.contains("+")) {
            int yIndex = z.indexOf("+");
            String zStr = z.substring(yIndex + 1);
            return Integer.parseInt(zStr);

        } else if (z.contains("-")) {
            int yIndex = z.indexOf("-");
            String zStr = z.substring(yIndex);
            return Integer.parseInt(zStr);
        } else {
            return 0;
        }
    }

    private static int generateNumber(int x, int y, int z) {
        int number = 0;
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            number += random.nextInt(y) + 1;
        }
        number += z;
        return number;
    }
}
