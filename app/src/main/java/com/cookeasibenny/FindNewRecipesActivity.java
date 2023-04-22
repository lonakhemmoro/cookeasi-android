package com.cookeasibenny;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindNewRecipesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecipeCardAdapter adapter;
    private ArrayList<Recipe.Result> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_new_recipes);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        recipeList = new ArrayList<>();
        adapter = new RecipeCardAdapter(this, recipeList);
        recyclerView.setAdapter(adapter);

        String inStockIngredients = FridgeItinerary.getInStockIngredients();
        fetchRecipes(inStockIngredients);
    }


    private void fetchRecipes(String inStockIngredients) {
        SpoonacularApi api = ApiClient.getRetrofitInstance().create(SpoonacularApi.class);

        Map<String, String> options = new HashMap<>();
        options.put("apiKey", "c3280ce00f614a3e84d7cd393353fdb5");
        options.put("includeIngredients", inStockIngredients);
        options.put("number", "10");
        options.put("sort", "min-missing-ingredients");
        options.put("instructionsRequired", "true");
        options.put("fillIngredients", "true");
        options.put("addRecipeInformation", "true");

        Call<Recipe.Root> call = api.getRecipes(options);
        System.out.println(inStockIngredients);
        call.enqueue(new Callback<Recipe.Root>() {
            @Override
            public void onResponse(Call<Recipe.Root> call, Response<Recipe.Root> response) {
                if (response.isSuccessful()) {
                    recipeList.clear();
                    recipeList.addAll(response.body().results);
                    adapter.notifyDataSetChanged();

                    // Add this log statement
                    Log.d("API JSON Body", response.body().toString());

                    Log.d("FindNewRecipesActivity", "recipeList size: " + recipeList.size());

                    // Set up the click listener for the "View Recipe" button
                    adapter.setOnItemClickListener(position -> {
                        // Handle the click event and open the recipe URL
                        String sourceUrl = recipeList.get(position).sourceUrl;
                        Log.d("Recipe URL", sourceUrl);
                    });
                } else {
                    Log.e("API Error", "Failed to fetch recipes");
                }
            }






            @Override
            public void onFailure(Call<Recipe.Root> call, Throwable t) {
                Log.e("API Error", "Failed to fetch recipes: " + t.getMessage());
            }
        });
    }
    private void parseRecipes(Recipe.Root response) {
        if (response != null && response.results != null) {
            recipeList.clear();
            recipeList.addAll(response.results);
            adapter.notifyDataSetChanged();
        } else {
            Log.e("FindNewRecipesActivity", "Failed to parse recipes from API response");
        }
    }

}
