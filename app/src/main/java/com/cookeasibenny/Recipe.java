package com.cookeasibenny;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private List<Step> steps;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static class Step {
        private List<Equipment> equipment;
        private List<Ingredient> ingredients;
        private Length length;
        private int number;
        private String step;

        // getters and setters
    }

    public static class Equipment {
        private int id;
        private String image;
        private String name;
        private Temperature temperature;

        // getters and setters
    }

    public static class Ingredient {
        private int id;
        private String image;
        private String name;

        // getters and setters
    }

    public static class Length {
        private double number;
        private String unit;

        // getters and setters
    }

    public static class Temperature {
        private double number;
        private String unit;

        // getters and setters
    }
}
