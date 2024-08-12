package org.example;

public class Cat extends Animal {
    private final int maxRunLength = 200;
    static int countCats = 0;
    static int foodInABowl; //количество корма в миске
    int catEating; //количество, которое кот пытается съесть

    boolean satiety;

    public Cat (String name){
        this.name = name;
        this.satiety = false;
        countCats ++;
    }

    public void run(int length) {
        if (length <= maxRunLength) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println("Превышена дистанция в " + maxRunLength + " м.");
        }
    }
    public void swim(int length) {
            System.out.println("Кот не умеет плавать");
    }

    public boolean eat(int catEating) {
        if (catEating <= foodInABowl){
            System.out.println(name +" поел");
            this.satiety = true;
            foodInABowl-=catEating;
        }
        else {
            System.out.println("Еды недостаточно");
        }
        return this.satiety;

    }

    public static int setFood(int foodAdded){
        return foodInABowl+=foodAdded;
    }

    public static int getCount() {
        return countCats;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "maxRunLength=" + maxRunLength +
                ", catEating=" + catEating +
                ", satiety=" + satiety +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }
}
