package org.example;

public class Circle implements Shape{
    private double radius;
    private String fillColor;
    private String bordersColor;

    public Circle(double radius, String fillColor, String bordersColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.bordersColor = bordersColor;
    }

    public double square() {
        return 3.14 * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String getFillColour() {
        return fillColor;
    }

    @Override
    public String getBordersColor() {
        return bordersColor;
    }

}
