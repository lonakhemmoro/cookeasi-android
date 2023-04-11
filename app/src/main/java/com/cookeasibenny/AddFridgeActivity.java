package com.cookeasibenny;

import static android.view.View.INVISIBLE;
import androidx.transition.Slide;
import androidx.appcompat.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.transition.Transition;
import android.view.Gravity;
public class AddFridgeActivity extends AppCompatActivity {

    //each button is broken down into respective catagories
    //imagebuttons that set visibility for each LL section
    //Cbasics is the navigation buttons in the middle of the activity
private ImageButton CBasics, CGrains, CVegetables, CProtein, CFruit;
//basics table, added more so add the proper buttons here
private Button Butter, Chili,egg,pepper,cilantro,flour,honey,chiliF,salt,cumin,pbutter,soysauce,sugar,vinagrette,broth,oregano,basil,oliveoil;
//grains table, added more so add the proper buttons here
private Button Toast, wrap,spaghetti,granola,quinoa;
//veggies table
private Button lime,cucumber,avocado,onion,carrot,veggiemix,celery,driedLentils,tomato,cannedtomato,bellpepper,blackbeans,potato,ginger,garlic,lettuce;
//protein table
private Button yogurt,cheese,chicken,almondmilk,hummus,groundbeef;
//fruit table
private Button frzbanana,frzberries;
//lowest buttons
private Button backtoFridge, BackToMenu;
//view groups for the collapsing tables
private android.view.ViewGroup BasicsVG, GrainsVG,VegetablesVG,ProteinVG,FruitVG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dont mess w this line, connects the xml to the java
        setContentView(R.layout.activity_add_fridge);
//these are linking the image buttons to the variables
        CBasics = (ImageButton) findViewById(com.cookeasibenny.R.id.BasicsCollapsebtn);
        CGrains = (ImageButton) findViewById(com.cookeasibenny.R.id.GrainsCollapsebtn);
        CVegetables = (ImageButton) findViewById(com.cookeasibenny.R.id.VegetablesCollapseBtn);
        CProtein = (ImageButton) findViewById(com.cookeasibenny.R.id.ProteinCollapseBtn);
        CFruit = (ImageButton) findViewById(com.cookeasibenny.R.id.FruitCollapseBtn);
// connects the viewgroups to the layouts, all layouts that are relavent are labeled in the xml
        BasicsVG = findViewById(com.cookeasibenny.R.id.BasicsCollapse);
        BasicsVG.setVisibility(android.view.View.GONE);
        //^ do this for all view groups pls

        // onclick listeners for nav bar
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

        //please add onclick listeners for all buttons for food here
        //add food buttons above.
    }
//public voids for visiiblity of food groups for buttons
    //all but visibilityBasics are empty, but that is the example, change R.id.BasicsCollapse to
    //respective collapse layout
    private void VisibilityGrains() {

    }

    public void VisibilityFruit() {

    }

    public void VisibilityProtein() {

    }

    public void VisibilityVegetables() {

    }

    public void VisibilityBasics() {

        android.view.ViewGroup Basics = findViewById(com.cookeasibenny.R.id.BasicsCollapse);
        Transition transition = new Slide(Gravity.BOTTOM);
        Transition transition1 = new Slide(Gravity.TOP);
        if (Basics.getVisibility()== android.view.View.GONE){
            transition.setDuration(300);
            transition.addTarget(Basics);
            androidx.transition.TransitionManager.beginDelayedTransition(Basics, transition);
            Basics.setVisibility(android.view.ViewGroup.VISIBLE);
        }
        else {
            Basics.setVisibility(android.view.ViewGroup.GONE);
        }
    }
}