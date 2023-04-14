package com.cookeasibenny;

import static com.cookeasibenny.FridgeItinerary.FridgeContents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class API_Handler {
    //pulls in stock ingredients from the fridge.
    public String getInStockIngredients() {
        StringBuilder sb = new StringBuilder();
        for (FridgeItinerary.Ingredient ingredient : FridgeContents.values()) {
            if (ingredient.getInStock()) {
                sb.append(ingredient.getName()).append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing comma
        }
        return sb.toString();
    }
    public static void Recipes(String[] args) {
        // Call the complexSearch API to get a list of recipes
        String inStockIngredients = FridgeItinerary.getInStockIngredients();
        List<Recipe> recipes = getRecipes(inStockIngredients);

        // Assume the user selects the first recipe in the list
        if (!recipes.isEmpty()) {
            Recipe selectedRecipe = recipes.get(0);
            // Call the analyzedInstructions API to get the recipe steps
            List<InstructionStep> steps = getRecipeSteps(selectedRecipe.getId());
        } else {
            System.out.println("No recipes found.");
        }
    }

    private static List<Recipe> getRecipes(String inStockIngredients) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        HttpUrl url = HttpUrl.parse("https://api.spoonacular.com/recipes/complexSearch").newBuilder()
                .addQueryParameter("apiKey", "c3280ce00f614a3e84d7cd393353fdb5")
                .addQueryParameter("includeIngredients", inStockIngredients)
                .addQueryParameter("number", "10") // get 10 results
                .addQueryParameter("instructionsRequired", "true")
                .addQueryParameter("fillIngredients", "true")
                .addQueryParameter("addRecipeInformation", "true")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            String responseBody = response.body().string();
            return parseRecipes(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static List<InstructionStep> getRecipeSteps(int recipeId) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        HttpUrl url = HttpUrl.parse("https://api.spoonacular.com/recipes/" + recipeId + "/analyzedInstructions").newBuilder()
                .addQueryParameter("apiKey", "c3280ce00f614a3e84d7cd393353fdb5")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            String responseBody = response.body().string();
            return parseInstructionSteps(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Helper methods to parse the response into Java objects
    private static List<Recipe> parseRecipes(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        return mapper.readValue(node.traverse(), new TypeReference<List<Recipe>>(){});
    }

    private static List<InstructionStep> parseInstructionSteps(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        return mapper.readValue(node.get(0).get("steps").traverse(), new TypeReference<List<InstructionStep>>(){});
    }

}
class Recipe {
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
class InstructionStep {
    private String step;
    private List<String> ingredients;

    public InstructionStep(String step, List<String> ingredients) {
        this.step = step;
        this.ingredients = ingredients;
    }

    public String getStep() {
        return step;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static List<InstructionStep> parseJSON(String jsonString) {
        List<InstructionStep> steps = new ArrayList<>();
        try {
            JSONArray stepsArray = new JSONArray(jsonString);
            for (int i = 0; i < stepsArray.length(); i++) {
                JSONObject stepObject = stepsArray.getJSONObject(i);
                JSONArray stepArray = stepObject.getJSONArray("steps");
                for (int j = 0; j < stepArray.length(); j++) {
                    JSONObject stepData = stepArray.getJSONObject(j);
                    String stepText = stepData.getString("step");
                    JSONArray ingredientArray = stepData.getJSONArray("ingredients");
                    List<String> ingredientList = new ArrayList<>();
                    for (int k = 0; k < ingredientArray.length(); k++) {
                        JSONObject ingredientData = ingredientArray.getJSONObject(k);
                        String ingredientName = ingredientData.getString("name");
                        ingredientList.add(ingredientName);
                    }
                    steps.add(new InstructionStep(stepText, ingredientList));
                }
            }
        } catch (JSONException e) {
            // Handle the exception here, such as logging the error or returning an empty list
        }
        return steps;
    }
}
//example usage
/*
String jsonString = "[{...}]"; // JSON data here
List<InstructionStep> steps = InstructionStep.parseJSON(jsonString);
for (InstructionStep step : steps) {
    System.out.println(step.getStep());
    System.out.println(step.getIngredients());
}

 */

//example output
/*Step 1: Preheat the oven to 200 degrees F.

Equipment: oven
Temperature: 200.0 Fahrenheit
Ingredients: None
Step 2: Whisk together the flour, pecans, granulated sugar, light brown sugar, baking powder, baking soda, and salt in a medium bowl.

Equipment: whisk, bowl
Ingredients:
all purpose flour
pecans
granulated sugar
light brown sugar
baking powder
baking soda
salt
Step 3: Whisk together the eggs, buttermilk, butter and vanilla extract and vanilla bean in a small bowl.

Equipment: whisk, bowl
Ingredients:
eggs
buttermilk
butter
vanilla extract
vanilla bean
Step 4: Add the egg mixture to the dry mixture and gently mix to combine. Do not overmix.

Equipment: None
Ingredients:
eggs
all purpose flour
pecans
granulated sugar
light brown sugar
baking powder
baking soda
salt
butter
vanilla extract
vanilla bean
Step 5: Let the batter sit at room temperature for at least 15 minutes and up to 30 minutes before using.

Equipment: None
Ingredients: None
Length: 15 minutes
Step 6: Heat a cast iron or nonstick griddle pan over medium heat and brush with melted butter. Once the butter begins to sizzle, use 2 tablespoons of the batter for each pancake and cook until the bubbles appear on the surface and the bottom is golden brown, about 2 minutes, flip over and cook until the bottom is golden brown, 1 to 2 minutes longer.

Equipment: griddle, frying pan
Ingredients:
eggs
all purpose flour
pecans
granulated sugar
light brown sugar
baking powder
baking soda
salt
butter
vanilla extract
vanilla bean
Step 7: Transfer the pancakes to a platter and keep warm in a 200 degree F oven.

Equipment: oven
Temperature: 200.0 Fahrenheit
Ingredients: None
 */