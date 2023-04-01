package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button Fridge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Fridge = (Button) findViewById(R.id.MA_OpenFridge);
Fridge.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openFridgeMA();
    }
});
        }
        public void openFridgeMA(){
        Intent openFridgeIntent = new Intent(this, FridgeActivity.class);
        startActivity(openFridgeIntent);
        }
    }
