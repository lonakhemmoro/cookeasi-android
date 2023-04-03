package com.cookeasibenny;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipes extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);








        List< itemRecipe> items = new ArrayList<com.cookeasibenny.itemRecipe>();
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Test recipe","the best test ever"));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Test recipe","the best test ever"));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Test recipe","the best test ever"));

        RecyclerView recyclerView = findViewById(//---------------);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterRecipe(getApplicationContext(),items));
    }
}
