package com.management.system.demo.enums;

public enum Country {
    BULGARIA("Bulgaria"),
    FRANCE("France"),
    ITALY("Italy");


    private String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country[] getCountryValues() {
        return Country.values();
    }
}
