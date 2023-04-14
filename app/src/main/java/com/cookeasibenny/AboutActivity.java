package com.cookeasibenny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private Button BackMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button backButton = findViewById(R.id.BackMain_about);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openBackMenu();}
        });
    }
    public void openBackMenu(){
        Intent openBackMenuIntent = new Intent(this, MainActivity.class);
        startActivity(openBackMenuIntent);
    }
}
