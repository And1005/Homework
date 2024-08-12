package org.example;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String bordersColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String bordersColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.bordersColor = bordersColor;
    }

    @Override
    public double square() {
        double semiperimeter = perimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
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
