package org.example;

public class Animal {
    int length;
    String name;
    static int countAnimals = 0;


    public Animal() {
        countAnimals ++;
    }

    public void run(int length) {
        //System.out.println(name + " пробежал " + length + " м.");
    }

    public void swim(int length) {
        //System.out.println(name + " проплыл " + length + " м.");
    }
    public static int getCount() {
        return countAnimals;
    }

}
