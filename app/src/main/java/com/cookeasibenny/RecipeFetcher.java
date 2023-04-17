package com.cookeasibenny;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeFetcher {
    private RecipeFetchListener listener;

    public RecipeFetcher(RecipeFetchListener listener) {
        this.listener = listener;
    }

    public void fetchRecipes(String inStockIngredients) {
        ApiService apiService = RetrofitClient.getApiService();
        Call<ResponseBody> call = apiService.getRecipes(
                "c3280ce00f614a3e84d7cd393353fdb5",
                inStockIngredients,
                10,
                true,
                true,
                true);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String jsonResponse = response.body().string();
                        ArrayList<Recipe.Result> recipes = parseRecipes(jsonResponse);
                        listener.onRecipesFetched(recipes);
                    } catch (IOException e) {
                        Log.e("RecipeFetcher", "Error reading response body", e);
                        listener.onRecipesFetchFailed("Error reading response body");
                    }
                } else {
                    listener.onRecipesFetchFailed("Request failed: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onRecipesFetchFailed("Request failed: " + t.getMessage());
            }
        });
    }

    private ArrayList<Recipe.Result> parseRecipes(String jsonResponse) {
        ArrayList<Recipe.Result> results = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonResponse);
            JSONArray resultsArray = root.getJSONArray("results");

            ObjectMapper objectMapper = new ObjectMapper();

            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject resultJson = resultsArray.getJSONObject(i);
                Recipe.Result result = objectMapper.readValue(resultJson.toString(), Recipe.Result.class);
                results.add(result);
            }
        } catch (Exception e) {
            Log.e("RecipeFetcher", "Error parsing JSON response", e);
        }
        return results;
    }

    public interface RecipeFetchListener {
        void onRecipesFetched(ArrayList<Recipe.Result> recipes);

        void onRecipesFetchFailed(String errorMessage);
    }
}
