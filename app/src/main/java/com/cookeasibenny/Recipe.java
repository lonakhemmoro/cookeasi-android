package com.cookeasibenny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AnalyzedInstruction {
        public String name;
        public ArrayList<Step> steps;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Equipment {
        public int id;
        public String name;
        public String localizedName;
        public String image;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtendedIngredient {
        public int id;
        public String aisle;
        public String image;
        public String consistency;
        public String name;
        public String nameClean;
        public String original;
        public String originalName;
        public double amount;
        public String unit;
        public ArrayList<String> meta;
        public Measures measures;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Ingredient {
        public int id;
        public String name;
        public String localizedName;
        public String image;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Length {
        public int number;
        public String unit;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Measures {
        public Us us;
        public Metric metric;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Metric {
        public double amount;
        public String unitShort;
        public String unitLong;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MissedIngredient {

        public int id;
        public double amount;
        public String unit;
        public String unitLong;
        public String unitShort;
        public String aisle;
        public String name;
        public String original;
        public String originalName;
        public ArrayList<Object> meta;
        public String image;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {

        public boolean vegetarian;
        public boolean vegan;
        public boolean glutenFree;
        public boolean dairyFree;
        public boolean veryHealthy;
        public boolean cheap;
        public boolean veryPopular;
        public boolean sustainable;
        public boolean lowFodmap;
        public int weightWatcherSmartPoints;
        public String gaps;
        public int preparationMinutes;
        public int cookingMinutes;
        public int aggregateLikes;
        public int healthScore;
        public String creditsText;
        public String sourceName;
        public double pricePerServing;
        public ArrayList<ExtendedIngredient> extendedIngredients;
        public int id;
        public String title;
        public int readyInMinutes;
        public int servings;
        public String sourceUrl;
        public String image;
        public String imageType;
        public String summary;
        public ArrayList<Object> cuisines;
        public ArrayList<String> dishTypes;
        public ArrayList<String> diets;
        public ArrayList<Object> occasions;
        public ArrayList<AnalyzedInstruction> analyzedInstructions;
        public String spoonacularSourceUrl;
        public int usedIngredientCount;
        public int missedIngredientCount;
        public int likes;
        public ArrayList<MissedIngredient> missedIngredients;
        public ArrayList<UsedIngredient> usedIngredients;
        public ArrayList<Object> unusedIngredients;
        public int getId() {
            return id;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Root {
        @Override
        public String toString() {
            return "Root{" +
                    "results=" + results +
                    '}';
        }
        public ArrayList<Result> results;
        public int offset;
        public int number;
        public int totalResults;
        public void clearResults() {
            if (results != null) {
                results.clear();
            }
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Step {
        public int number;
        public String step;
        public ArrayList<Ingredient> ingredients;
        public ArrayList<Equipment> equipment;
        public Length length;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Us {
        public double amount;
        public String unitShort;
        public String unitLong;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UsedIngredient {
        public int id;
        public double amount;
        public String unit;
        public String unitLong;
        public String unitShort;
        public String aisle;
        public String name;
        public String original;
        public String originalName;
        public ArrayList<String> meta;
        public String image;
    }
}

