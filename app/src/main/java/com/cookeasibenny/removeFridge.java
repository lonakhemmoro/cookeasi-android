package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class removeFridge extends AppCompatActivity {
Button removeAll;
Button GoFridge;
Button GoRecipe;
    private FridgeItinerary fridgeItinerary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_fridge);

        fridgeItinerary = FridgeItinerary.getInstance();

        removeAll = (Button) findViewById(com.cookeasibenny.R.id.removeAllBtn);
        GoFridge = (Button) findViewById(com.cookeasibenny.R.id.BackToMenuBtn);
        GoRecipe = (Button) findViewById(com.cookeasibenny.R.id.FindRecipeBtn);

        removeAll.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View x){
                fridgeItinerary.removeAllIngredients();
                android.widget.Toast.makeText(removeFridge.this,"removed all ingredients", android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }
}