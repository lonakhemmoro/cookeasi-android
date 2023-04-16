package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;
public class RecipePage1 extends AppCompatActivity {
String TitleRecipe;
TextView ContentRecipe;
ImageView RecipePicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cookeasibenny.R.layout.recipepagelayout);
        String recipeName;
        recipeName = getIntent().getStringExtra("recipe_name");

        RecipePicture  = (ImageView) findViewById(com.cookeasibenny.R.id.RecipePagePicture);
        ContentRecipe = (TextView) findViewById(com.cookeasibenny.R.id.Directions);
        TitleRecipe = String.valueOf((android.widget.TextView) findViewById(com.cookeasibenny.R.id.RecipePageTitle));

        String titleRecipe1 = getIntent().getStringExtra("recipe_name");

        ContentRecipe.setText(titleRecipe1);
    }
}