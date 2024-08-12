package org.example;

class Rectangle implements Shape {

    private double width; //ширина
    private double height; //высота
    private String fillColor;
    private String bordersColor;

    public Rectangle(double width, double height, String fillColor, String bordersColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.bordersColor = bordersColor;
    }
    public double square() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getFillColour() {
        return fillColor;
    }

    public String getBordersColor() {
        return bordersColor;
    }
}
