package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button Fridge;
private Button Recycler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

Fridge = (Button) findViewById(R.id.MA_OpenFridge);
Recycler = (Button) findViewById(R.id.RecyclerButtton1);
Fridge.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        openFridgeMA();
    }
});
Recycler.setOnClickListener(new View.OnClickListener(){

    public void onClick(View w){
        openRecyclerMA();
    }
});






        }

        public void openRecyclerMA(){
        Intent openRecyclerIntent = new Intent(this, SearchRecipes.class);
        startActivity(openRecyclerIntent);
        }
        public void openFridgeMA(){
        Intent openFridgeIntent = new Intent(this, FridgeActivity.class);
        startActivity(openFridgeIntent);
        }

    }

