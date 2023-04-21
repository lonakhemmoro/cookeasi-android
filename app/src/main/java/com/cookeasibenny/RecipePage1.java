package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class RecipePage1 extends AppCompatActivity {
String TitleRecipe;
TextView ContentRecipe;
ImageView imageview;
int RecipePicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(com.cookeasibenny.R.layout.recipepagelayout);
        String recipeName;
        recipeName = getIntent().getStringExtra("recipe_name");
        String ingredientName = getIntent().getStringExtra("ingredientName");

imageview = findViewById(com.cookeasibenny.R.id.RecipePagePicture);
        ContentRecipe = (TextView) findViewById(com.cookeasibenny.R.id.Directions);
        TitleRecipe = String.valueOf((android.widget.TextView) findViewById(com.cookeasibenny.R.id.RecipePageTitle));
 RecipePicture = bundle.getInt("image");
 imageview.setImageResource(RecipePicture);
        String titleRecipe1 = getIntent().getStringExtra("recipe_name");

        ContentRecipe.setText(titleRecipe1);
    }
}