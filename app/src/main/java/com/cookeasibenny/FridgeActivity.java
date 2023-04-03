package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FridgeActivity extends AppCompatActivity {
    private Button BackMenu;
    private Button Rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);
        BackMenu = (Button) findViewById(R.id.BackMenu);
        Rec =(Button) findViewById(R.id.FA_AddItems);
        BackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackMenu();
            }
        });

    }



    public void openBackMenu(){
        Intent openBackMenuIntent = new Intent(this, MainActivity.class);
        startActivity(openBackMenuIntent);
    }
    }
