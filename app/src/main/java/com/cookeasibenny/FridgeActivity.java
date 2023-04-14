package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FridgeActivity extends AppCompatActivity {
    private Button BackMenu;
    private Button Rec;

    private Button openFridge;

    private Button removeItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);
        BackMenu = (Button) findViewById(R.id.BackMenu);
        Rec =(Button) findViewById(R.id.FA_AddItems);
        openFridge = findViewById(R.id.FA_OpenFridge);
        removeItems = findViewById(R.id.FA_RemoveItems);
        BackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackMenu();
            }
        });
Rec.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        OpenAddfridge();
    }
});

        openFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openFridge = new Intent(getApplicationContext(), OpenFridge.class);
                startActivity(openFridge);
            }
        });

        removeItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FridgeItinerary.getInstance().removeAllIngredients();
                Toast.makeText(FridgeActivity.this, "Fridge is emptied", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OpenAddfridge() {
        Intent openAddFridge = new Intent(this, AddFridgeActivity.class);
        startActivity(openAddFridge);
    }


    public void openBackMenu(){
        Intent openBackMenuIntent = new Intent(this, MainActivity.class);
        startActivity(openBackMenuIntent);
    }
    }
