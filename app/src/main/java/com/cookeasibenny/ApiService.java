package com.cookeasibenny;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("recipes/complexSearch")
    Call<ResponseBody> getRecipes(
            @Query("apiKey") String apiKey,
            @Query("includeIngredients") String inStockIngredients,
            @Query("number") int number,
            @Query("instructionsRequired") boolean instructionsRequired,
            @Query("fillIngredients") boolean fillIngredients,
            @Query("addRecipeInformation") boolean addRecipeInformation);
}
