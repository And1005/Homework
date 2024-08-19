package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Январь");
        arrayList.add("Февраль");
        arrayList.add("Март");
        arrayList.add("Апрель");
        arrayList.add("Май");
        arrayList.add("Июнь");
        arrayList.add("Июль");
        arrayList.add("Август");
        arrayList.add("Сентябрь");
        arrayList.add("Октябрь");
        arrayList.add("Ноябрь");
        arrayList.add("Декабрь");
        arrayList.add("Январь");
        arrayList.add("Февраль");
        arrayList.add("Март");
        arrayList.add("Апрель");
        arrayList.add("апрель");
        System.out.println("Первоначальная коллекция :" + arrayList);

        Set<String> set = new HashSet<>(arrayList);
        System.out.println("Вывод уникальных значений :" + set);

        Map<String, Integer> map = new HashMap<>();
        for (String month : arrayList) {
            String lowercaseMonth = month.toLowerCase();
            map.put(lowercaseMonth, map.getOrDefault(lowercaseMonth, 0) + 1);
        }

        System.out.println();

        System.out.println("Месяцы и их количество в коллекции:");
        map.forEach((month, count) -> System.out.println(month + ": " + map.get(month)));

        //Задание 2
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "+79998545740");
        phoneBook.add("Ivanov", "+79998545741");
        phoneBook.add("Smirnov", "+79998545742");
        phoneBook.add("Petrov", "+79998545743");
        phoneBook.add("Ivanov", "+79998545744");

        System.out.println("Номера телефонов по фамилии Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Номера телефонов по фамилии Petrov: " + phoneBook.get("Petrov"));
        System.out.println("Номера телефонов по фамилии Smirnov: " + phoneBook.get("Smirnov"));
    }
}