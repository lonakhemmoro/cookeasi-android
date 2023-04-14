package com.cookeasibenny;

import static com.cookeasibenny.FridgeItinerary.FridgeContents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
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
        Recipe selectedRecipe = recipes.get(0);

        // Call the analyzedInstructions API to get the recipe steps
        List<InstructionStep> steps = getRecipeSteps(selectedRecipe.getId());
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