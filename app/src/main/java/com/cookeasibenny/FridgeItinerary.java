package com.cookeasibenny;

import java.util.HashMap;
import java.util.Map;

public class FridgeItinerary {

    private static FridgeItinerary instance;
    public static Map<String, Ingredient> FridgeContents = new HashMap<>();

    public static FridgeItinerary getInstance() {
        if (instance == null) {
            instance = new FridgeItinerary();
        }
        return instance;
    }

    public void addIngredient(String name) {
        Ingredient ingred = new Ingredient(name);
        FridgeContents.put(name.toLowerCase(), ingred);
    }

    public void addIngredient(String name, boolean inStock) {
        Ingredient ingred = new Ingredient(name, inStock);
        FridgeContents.put(name.toLowerCase(), ingred);
    }

    public void removeIngredient(String name) {
        for (String ingredientName : FridgeContents.keySet()) {
            if (ingredientName.equalsIgnoreCase(name)) {
                FridgeContents.remove(ingredientName);
                break;
            }
        }
    }

    public void removeAllIngredients() {
        FridgeContents.clear();
    }

    public void setInStock(String name, boolean inStock) {
        Ingredient ingred = FridgeContents.get(name.toLowerCase());
        if (ingred != null) {
            ingred.setInStock(inStock);
        }
    }

    public void printItinerary() {
        System.out.println("Ingredient Itinerary:");
        System.out.println("---------------------");
        for (Ingredient ingred : FridgeContents.values()) {
            System.out.println(ingred.getInStock() + " " + ingred.getName());
        }
    }

    public static String getInStockIngredients() {
        StringBuilder sb = new StringBuilder();
        for (Ingredient ingredient : FridgeContents.values()) {
            if (ingredient.getInStock()) {
                sb.append(ingredient.getName()).append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing comma
        }
        return sb.toString();
    }

    public static class Ingredient {
        private String name;
        private boolean inStock;

        public Ingredient(String name) {
            this.name = name;
            this.inStock = true;
        }

        public Ingredient(String name, boolean inStock) {
            this.name = name;
            this.inStock = inStock;
        }

        public String getName() {
            return name;
        }

        public boolean getInStock() {
            return inStock;
        }

        public void setInStock(boolean inStock) {
            this.inStock = inStock;
        }

        public void setNotInStock(String name) {
            Ingredient ingred = FridgeContents.get(name.toLowerCase());
            if (ingred != null) {
                ingred.setInStock(false);
            }
        }
    }
//tester
 /*   public static void main(String[] args) {
        // Add ingredients
        addIngredient("flour");
        addIngredient("sugar", true);
        addIngredient("butter", false);
        addIngredient("eggs");

        // Set inStock for some ingredients
        setInStock("flour", false);
        setInStock("butter", true);

        // Remove an ingredient
        removeIngredient("eggs");

        // Add a new ingredient
        addIngredient("milk", true);

        // Print the itinerary
        printItinerary();
    }*/
}
