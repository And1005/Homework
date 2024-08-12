package org.example;

public class AnimalsApp {

    public static void main(String[] args) {

        Dog dog = new Dog("Шарик");
        Dog dog1 = new Dog("Дружок");
        dog.run(501);
        dog.swim(11);
        dog1.run(500);
        dog1.swim(10);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Снежок");
        cats[2] = new Cat("Матроскин");
        cats[3] = new Cat("Барсик");
        cats[4] = new Cat("Багира");

        cats[0].run(200);
        cats[1].run(201);
        cats[0].swim(1);

        Cat.setFood(30);

        for (Cat cat : cats) {
            cat.eat(10);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + cats[i].name + " - сытость = " + cats[i].satiety);
        }

        System.out.println("Общее количество животных: " + Animal.getCount());
        System.out.println("Общее количество собак: " + Dog.getCount());
        System.out.println("Общее количество котов: " + Cat.getCount());

    }
}
