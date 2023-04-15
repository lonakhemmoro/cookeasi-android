package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecipePage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cookeasibenny.R.layout.recipepagelayout);
        String recipeName = getIntent().getStringExtra("recipe_name");
    }
}