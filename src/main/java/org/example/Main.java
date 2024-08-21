package org.example;
import java.util.Scanner;

import static org.example.Factorial.factorial;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое число для вычисления его факториала: ");
        int number = scanner.nextInt();

        int factorialResult = factorial(number);
        System.out.println("Факториал числа " + number + " = " + factorialResult);
    }
}