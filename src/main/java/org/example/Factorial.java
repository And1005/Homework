package org.example;

public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не может быть отрицательным");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}