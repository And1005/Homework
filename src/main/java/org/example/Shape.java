package org.example;

public interface Shape {
    double square();
    double perimeter();

    String getFillColour();
    String getBordersColor();

    default void displayCharacteristics() {
        System.out.println("Площадь: " + square());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Цвет заливки: " + getFillColour());
        System.out.println("Цвет границы: " + getBordersColor());
    }
}
