package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    Shape circle = new Circle(7.0, "Серый", "Синий");
    Shape rectangle = new Rectangle(5.0, 10.0, "Желтый", "Зеленый");
    Shape triangle = new Triangle(8.0, 7.0, 12.0, "Коричневый", "Красный");

        circle.displayCharacteristics();
        rectangle.displayCharacteristics();
        triangle.displayCharacteristics();
    }
}