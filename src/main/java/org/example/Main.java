package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1 и 2:");

            /*Employee employee = new Employee("Ларюшкин Андрей Игоревич", "Тестировщик",
                    "andre@yandex.ru", "+79515545472", 50000.50, 35);
            employee.info();*/

        Employee [] employees = new Employee[5];
        employees[0] = new Employee("Ларюшкин Андрей Игоревич", "Тестировщик",
                "andre@yandex.ru", "+79515545472", 50000.50, 35);
        employees[1] = new Employee("Иванов Иван Иванович", "Менеджер",
                "ivan@yandex.ru", "+79515545473", 100000.50, 36);
        employees[2] = new Employee("Петров Петр Петрович", "Разработчик FE",
                "petr@yandex.ru", "+79515545474", 120000.50, 37);
        employees[3] = new Employee("Светлова Светлана Святославовна", "Аналитик",
                "svetlana@yandex.ru", "+79515545475", 80000.50, 38);
        employees[4] = new Employee("Зайцев Степан Петрович", "Разработчик BE",
                "stepan@yandex.ru", "+79515545476", 120000.50, 39);

        for (Employee employee : employees){
            employee.info();
            System.out.println("--------------------------");
        }

        System.out.println("Задание 3:");

        Park park = new Park("Орлёнок", "+747322044557");
        Park.Attraction attraction = park.new Attraction("Емеля", "10:00-21:00", 400);

        park.parkInfo();
        attraction.attractionInfo();
    }
}
