package com.cookeasibenny;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SpoonacularApi {
    @GET("recipes/complexSearch")
    Call<Recipe.Root> getRecipes(@QueryMap Map<String, String> options);
}
