package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int choice = 0;

        while (choice != 99) {
            System.out.println("Welcome to the calculator app");
            System.out.println("Please choose the operation you want to perform");
            System.out.println("1. Power");
            System.out.println("2. nCr");
            System.out.println("3. GCD");
            System.out.println("99. Exit");

            choice = reader.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You have chosen the power function");
                    System.out.println("Please enter base and exponent");
                    int base = reader.nextInt();
                    int exp = reader.nextInt();
                    int answer = power(base, exp);
                    System.out.println(base + " raised to the power " + exp + " is: ");
                    System.out.println(answer);
                    break;

                case 2:
                    System.out.println("You have chosen the nCr function");
                    System.out.println("Please enter n and r");
                    int n = reader.nextInt();
                    int r = reader.nextInt();
                    if (n >= r) {
                        int nCrResult = calculateBinomialCoefficient(n, r);
                        System.out.println("nCr for n = " + n + " and r = " + r + " is:");
                        System.out.println(nCrResult);
                    } else {
                        System.out.println("r cannot be greater than n");
                    }
                    break;

                case 3:
                    System.out.println("You have chosen the GCD function");
                    System.out.println("Please enter the two numbers");
                    int a = reader.nextInt();
                    int b = reader.nextInt();
                    System.out.println("GCD of " + a + " and " + b + " is: ");
                    System.out.println(gcd(a, b));
                    break;

                case 99:
                    System.out.println("Exiting the calculator app. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        // Close the scanner to prevent resource leak
        reader.close();
    }

    public static int power(int base, int exp){
        int initialBase = base;
        int initialExp = exp;
        int result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base;
            exp >>= 1;
        }
        return result;
    }

    static int calculateBinomialCoefficient(int n, int r) {
        // Base cases
        if (r == 0 || r == n) {
            return 1;
        }

        // Recurrence relation: C(n, r) = C(n-1, r-1) + C(n-1, r)
        return calculateBinomialCoefficient(n - 1, r - 1) + calculateBinomialCoefficient(n - 1, r);
    }

    public static int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
