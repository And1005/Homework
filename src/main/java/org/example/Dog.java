package org.example;

public class Dog extends Animal{
    private final int maxRunLength = 500;
    private final int maxSwimLength = 10;

    static int countDogs = 0;

    public Dog (String name){
        this.name = name;
        countDogs ++;
    }

    @Override
    public void run (int length) {
        if (length <= maxRunLength) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println("Превышена дистанция в " + maxRunLength + " м.");
        }
    }
    public void swim (int length) {
        if (length <= maxSwimLength) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println("Превышена дистанция в " + maxSwimLength + " м.");
        }
    }

    public static int getCount() {
        return countDogs;
    }

}
