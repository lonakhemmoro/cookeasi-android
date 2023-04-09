package com.cookeasibenny;

import static android.view.View.INVISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddFridgeActivity extends AppCompatActivity {

    //each button is broken down into respective catagories
    //imagebuttons that set visibility for each LL section
private ImageButton CBasics, CGrains, CVegetables, CProtein, CFruit;
//basics table
private Button Butter, Chili,egg,pepper,cilantro,flour,honey,chiliF,salt,cumin,pbutter,soysauce,sugar,vinagrette,broth,oregano,basil,oliveoil;
//grains table
private Button Toast, wrap,spaghetti,granola,quinoa;

private Button lime,cucumber,avocado,onion,carrot,veggiemix,celery,driedLentils,tomato,cannedtomato,bellpepper,blackbeans,potato,ginger,garlic,lettuce;

private Button yogurt,cheese,chicken,almondmilk,hummus,groundbeef;

private Button frzbanana,frzberries;

private Button backtoFridge, BackToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fridge);

        CBasics = (ImageButton) findViewById(com.cookeasibenny.R.id.BasicsCollapsebtn);
        CGrains = (ImageButton) findViewById(com.cookeasibenny.R.id.GrainsCollapsebtn);
        CVegetables = (ImageButton) findViewById(com.cookeasibenny.R.id.VegetablesCollapseBtn);
        CProtein = (ImageButton) findViewById(com.cookeasibenny.R.id.ProteinCollapseBtn);
        CFruit = (ImageButton) findViewById(com.cookeasibenny.R.id.FruitCollapseBtn);

        CBasics.setOnClickListener( new View.OnClickListener(){
            public void onClick(View x){VisibilityBasics();}
        });

        CGrains.setOnClickListener( new View.OnClickListener(){
            public void onClick(View x){VisibilityGrains();}});
        CVegetables.setOnClickListener( new View.OnClickListener(){
            public void onClick(View x){VisibilityVegetables();}});
        CProtein.setOnClickListener( new View.OnClickListener(){
            public void onClick(View x){VisibilityProtein();}});
        CFruit.setOnClickListener( new View.OnClickListener(){
            public void onClick(View x){VisibilityFruit();}});
    }

    private void VisibilityGrains() {

    }

    public void VisibilityFruit() {

    }

    public void VisibilityProtein() {

    }

    public void VisibilityVegetables() {

    }

    public void VisibilityBasics() {
        View Basics = findViewById(com.cookeasibenny.R.id.BasicsCollapse);
        if (Basics.getVisibility()== android.view.View.VISIBLE){
            Basics.setVisibility(android.view.View.GONE);
        }
        else {
            Basics.setVisibility(android.view.View.VISIBLE);
        }
    }
}