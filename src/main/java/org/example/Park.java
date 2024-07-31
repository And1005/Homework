package org.example;

class Park {

    public void parkInfo() {
        System.out.println("Наименование парка: " + name + ", контактная информация: " + contactInformation);
    }

    private String name;
    private String contactInformation;

    public Park(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public class Attraction {
        private String attractionName;
        private String openingHours;
        private double cost;

        public Attraction(String attractionName, String openingHours, double cost) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.cost = cost;
        }

        public void attractionInfo() {
            System.out.println("Наименование аттракциона: " + attractionName + ", часы работы: " + openingHours + ", стоимость: " + cost);
        }
    }


}