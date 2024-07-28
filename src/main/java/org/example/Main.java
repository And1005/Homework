package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(printThreeWords());
        System.out.println(checkSumSign());
        System.out.println(printColor());
        System.out.println(compareNumbers());
        System.out.println(sumTwoNumbers(7, 3));
        System.out.println(isPositive(-7));
        System.out.println(isNegative(-1));
        System.out.println(printText("Hello!", 3));
        System.out.println(isLeapYear(300));
        System.out.println(Arrays.toString(array()));
        System.out.println(Arrays.toString(array100()));
        System.out.println(Arrays.toString(array6x2()));
        Arrays.stream(arrayTable()).map(Arrays::toString).forEach(System.out::println);
        System.out.println(Arrays.toString(array14(7, 121)));
    }

    // Лекция 7, упр.1
    public static String printThreeWords() {
        String fruit = "";
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        return fruit;
    }

    // Лекция 7, упр.2
    public static String checkSumSign() {
        int a = 5;
        int b = 12;
        String c = "";
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        return c;
    }

    // Лекция 7, упр.3
    public static String printColor() {
        int value = 101;
        String colour = "";
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
        return colour;
    }

    // Лекция 7, упр.4
    public static String compareNumbers() {
        int a = 1;
        int b = 2;
        String result = "";
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
        return result;
    }

    // Лекция 7, упр.5
    public static boolean sumTwoNumbers(int x, int y) {
        if (x + y >= 10 && x + y <= 20) return true;
        return false;
    }

    // Лекция 7, упр.6
    public static String isPositive(int x) {
        String number;
        if (x >= 0) return number = "Позитивное";
        return number = "Негативное";
    }

    // Лекция 7, упр.7
    public static boolean isNegative(int x) {
        if (x < 0) return true;
        return false;
    }

    // Лекция 7, упр.8
    public static String printText(String text, int x) {
        String a = "";
        for (int i = 1; i <= x; i++) System.out.println(text);
        return a;
    }

    // Лекция 7, упр.9
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 || year % 400 == 0) && !(year % 400 != 0 && year % 100 == 0)) return true;
        return false;
    }

    // Лекция 7, упр.10
    public static int[] array() {
        int[] arr = {0, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
        }
        return arr;
    }

    // Лекция 7, упр.11
    public static int[] array100() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // Лекция 7, упр.12
    public static int[] array6x2() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }

    // Лекция 7, упр.13
    public static int[][] arrayTable() {
        int[][] table = new int[5][5];
        //int counter = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i] == table[j]) {
                    table[i][j] = 1;
                } else table[i][j] = 0;
            }
        }
        return table;
    }


    // Лекция 7, упр.14
    public static int[] array14(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}