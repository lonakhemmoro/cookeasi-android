package com.cookeasibenny;

import java.util.*;

public class FridgeItinerary {
    private Map<String, Ingredient> ingredients = new HashMap<>();

    public void addIngredient(String name, double quantity, String measurement) {
        Ingredient ingredient = new Ingredient(name, quantity, measurement);
        ingredients.put(name.toLowerCase(), ingredient);
    }

    public void removeIngredient(String name) {
        ingredients.remove(name.toLowerCase());
    }

    public void addQuantity(String name, double quantity) {
        Ingredient ingredient = ingredients.get(name.toLowerCase());
        if (ingredient != null) {
            ingredient.addQuantity(quantity);
        }
    }

    public void subtractQuantity(String name, double quantity) {
        Ingredient ingredient = ingredients.get(name.toLowerCase());
        if (ingredient != null) {
            ingredient.subtractQuantity(quantity);
            if (ingredient.getQuantity() <= 0) {
                ingredients.remove(name.toLowerCase());
            }
        }
    }

    public void changeMeasurement(String name, String measurement) {
        Ingredient ingredient = ingredients.get(name.toLowerCase());
        if (ingredient != null) {
            ingredient.setMeasurement(measurement);
        }
    }

    public void printItinerary() {
        System.out.println("Fridge Itinerary:");
        System.out.println("---------------------");
        for (Ingredient ingredient : ingredients.values()) {
            System.out.println(ingredient.getQuantity() + " " + ingredient.getMeasurement() + " " + ingredient.getName());
        }
    }

    private class Ingredient {
        private String name;
        private double quantity;
        private String measurement;

        public Ingredient(String name, double quantity, String measurement) {
            this.name = name;
            this.quantity = quantity;
            this.measurement = measurement;
        }

        public String getName() {
            return name;
        }

        public double getQuantity() {
            return quantity;
        }

        public String getMeasurement() {
            return measurement;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public void setMeasurement(String measurement) {
            this.measurement = measurement;
        }

        public void addQuantity(double quantity) {
            this.quantity += quantity;
        }

        public void subtractQuantity(double quantity) {
            this.quantity -= quantity;
        }
    }
}