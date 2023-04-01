package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchRecipes extends AppCompatActivity {
private androidx.recyclerview.R RecipeRecycler;
private androidx.recyclerview.widget.LinearLayoutManager RecipeLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);
sampleRecipes();
//this is the start to an array we can use for the recipe list, then we can add onclick to these later
ArrayList<RecipeData> recipeData = new ArrayList<>();
recipeData.add(new RecipeData(R.drawable.veggie_button, "This is a Title", "this is a subheader"));
EditText searchFunction1 = findViewById(R.id.search);



    }


    private void sampleRecipes(){

    }


}