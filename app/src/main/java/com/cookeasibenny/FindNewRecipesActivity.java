package com.cookeasibenny;

import android.content.Intent;
import android.net.Uri;
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

// :)
// Finalized code
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

        recipeList.clear();
        adapter.notifyDataSetChanged();

        Recipe.Root root = new Recipe.Root();
        root.clearResults();

        Map<String, String> options = new HashMap<>();
        options.put("apiKey", "c3280ce00f614a3e84d7cd393353fdb5");
        options.put("includeIngredients", inStockIngredients);
        options.put("number", "60");
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
                    Log.d("API JSON Body", response.body().toString());
                    Log.d("FindNewRecipesActivity", "Received results size: " + response.body().results.size());
                    recipeList.clear();
                    recipeList.addAll(response.body().results);

                    Log.d("FindNewRecipesActivity", "Updated recipeList size: " + recipeList.size());
                    adapter.notifyDataSetChanged();

                    // Set up the click listener for the "View Recipe" button
                    adapter.setOnItemClickListener(position -> {
                        // Handle the click event and open the recipe URL
                        String spoonacularSourceUrl = recipeList.get(position).spoonacularSourceUrl;
                        Log.d("Recipe URL", spoonacularSourceUrl);

                        // Open the URL in Chrome or the default browser
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(spoonacularSourceUrl));
                        startActivity(browserIntent);
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
