/*package com.cookeasibenny;

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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class API_Handler {

    public interface RecipeFetchListener {
        void onRecipesFetched(List<Recipe> recipes);

        void onError(String message);
    }

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
            List<instructionStep> steps = getRecipeSteps(selectedRecipe.getId());
        } else {
            System.out.println("No recipes found.");
        }
    }

    private static List<Recipe> getRecipes(String inStockIngredients, RecipeFetchListener listener) {
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

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    try {
                        String responseBody = response.body().string();
                        List<Recipe> recipes = parseRecipes(responseBody);
                        listener.onRecipesFetched(recipes);
                    } catch (IOException e) {
                        listener.onError(e.getMessage());
                    }
                } else {
                    listener.onError("Unexpected response code: " + response);
                }
            }
        });
    }

    private static List<instructionStep> getRecipeSteps(int recipeId) {
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

}
        // Helper methods to parse the response into Java objects
        // Helper methods to parse the response into Java objects
    private List<Recipe> parseRecipes (String json) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json).get("results");
            return mapper.readValue(node.traverse(), new TypeReference<List<Recipe>>() {
            });
        }

        private List<InstructionStep> parseInstructionSteps (String json) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json);
            return mapper.readValue(node.get(0).get("steps").traverse(), new TypeReference<List<InstructionStep>>() {
            });
        }
    }

class instructionStep {
    private String step;
    private List<String> ingredients;

    public instructionStep(String step, List<String> ingredients) {
        this.step = step;
        this.ingredients = ingredients;
    }

    public String getStep() {
        return step;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static List<instructionStep> parseJSON(String jsonString) {
        List<instructionStep> steps = new ArrayList<>();
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
                    steps.add(new instructionStep(stepText, ingredientList));
                }
            }
        } catch (JSONException e) {
            // Handle the exception here, such as logging the error or returning an empty list
        }
        return steps;
    }
}*/