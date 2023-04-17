package com.cookeasibenny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button Fridge;
    private Button About;
    private Button FindRecipe;
    private Button FindNewRecipes;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fridge = (Button) findViewById(R.id.MA_OpenFridge);
        About = (Button) findViewById(R.id.MA_About);
        FindRecipe = (Button) findViewById(R.id.MA_FindRecipe);
        FindNewRecipes = (Button) findViewById(R.id.MA_FindNewRecipes);

        Fridge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFridgeMA();
            }
        });

        About.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w){
                openAboutMA();
            }
        });

        FindRecipe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View w){openMA_FindRecipe();}
        });

        FindNewRecipes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openFindNewRecipesActivity();
            }
        });
    }

    private void openAboutMA() {
        Intent openAboutIntent = new Intent(this, AboutActivity.class);
        startActivity(openAboutIntent);
    }

    public void openRecyclerMA(){
        Intent openRecyclerIntent = new Intent(this, SearchRecipes.class);
        startActivity(openRecyclerIntent);
    }

    public void openFridgeMA(){
        Intent openFridgeIntent = new Intent(this, FridgeActivity.class);
        startActivity(openFridgeIntent);
    }

    public void openMA_FindRecipe(){
        Intent openFindRecipeIntent = new Intent(this, SearchRecipes.class);
        startActivity(openFindRecipeIntent);
    }

    public void openFindNewRecipesActivity(){
        Intent openFindNewRecipesIntent = new Intent(this, FindNewRecipesActivity.class);
        startActivity(openFindNewRecipesIntent);
    }
}
