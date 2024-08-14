package org.example;

public class Main {
    public static void main(String[] args) {

        String[][] correctArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        String[][] incorrectSizeArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        String[][] incorrectDataArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"тринадцать", "14", "15", "16"}
        };

        try {
            int sum = checkArray(correctArr);
            System.out.println("Сумма элементов массива = " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            int sum = checkArray(incorrectSizeArr);
            System.out.println("Сумма элементов массива = " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            int sum = checkArray(incorrectDataArr);
            System.out.println("Сумма элементов массива = " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
    public static int checkArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 || array[i].length != 4) {
                    throw new MyArraySizeException("Размер массива должен быть 4x4, найден " + array.length + "x" + array[i].length);
                }else {

                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "] - значение '" + array[i][j] + "'");
                    }
                }
            }
        }

        return sum;
    }
}
