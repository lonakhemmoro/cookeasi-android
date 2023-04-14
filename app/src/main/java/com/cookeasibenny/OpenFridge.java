package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;

public class OpenFridge extends AppCompatActivity {

    ListView listView;
    FridgeItinerary fridgeItinerary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_fridge);

        String [] ingredientsNameArray = new String[fridgeItinerary.FridgeContents.size()];
        // Get the values from the map
        Collection<FridgeItinerary.Ingredient> ingredientCollection = fridgeItinerary.FridgeContents.values();

        // Create an array to store the values
        FridgeItinerary.Ingredient[] ingredientsArray = new FridgeItinerary.Ingredient[ingredientCollection.size()];

        // Copy the values into the array
        ingredientCollection.toArray(ingredientsArray);

        for (int i = 0; i <  fridgeItinerary.FridgeContents.size(); i++) {
            ingredientsNameArray[i] = ingredientsArray[i].getName();
        }

        listView = findViewById(R.id.ingredientsListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ingredientsNameArray);

        listView.setAdapter(adapter);
    }
}