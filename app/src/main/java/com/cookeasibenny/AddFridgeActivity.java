package com.cookeasibenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class AddFridgeActivity extends AppCompatActivity {
private Button CBasics, CGrains, CVegetables, CProtein, CFruit;

private Button Butter, Chili,egg,pepper,cilantro,flour,honey,chiliF,salt,cumin,pbutter,soysauce,sugar,vinagrette,broth,oregano,basil,oliveoil;

private Button Toast, wrap,spaghetti,granola,quinoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fridge);

        CBasics = (Button) findViewById(BasicsCollapsebtn);
    }
}