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
        Button button = findViewById(com.cookeasibenny.R.id.GithubButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/lonakhemmoro/cookeasi-android";
                Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    startActivity(intent);
                } catch (android.content.ActivityNotFoundException e) {
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });



    }


    public void openBackMenu(){
        Intent openBackMenuIntent = new Intent(this, MainActivity.class);
        startActivity(openBackMenuIntent);
    }
}
