package com.cookeasibenny;

import androidx.transition.Slide;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
private Button milk, cinnamon, mayo, brownSugar, bakingPowder, vanilla, butter, chili,egg,pepper,cilantro,flour,honey,chiliF,salt,cumin,pbutter,soysauce,sugar,vinagrette,broth,oregano,basil,oliveoil;
//grains table, added more so add the proper buttons here
private Button bread, oats, grits, barley, risotto, puffPastry, toast, wholeGrainWrap, spaghetti, granola, rice, quinoa;
//veggies table
private Button lime, cucumber, avocado, onion, carrot, veggieMix, celery, driedLentils, tomato, cannedTomatoes, bellPepper, blackBeans, potato, ginger, garlic, lettuce;
//protein table
private Button greekYogurt, cheese, chicken, almondMilk, hummus, salmon, groundBeef;
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

        //basics linking buttons variables to the buttons
        milk = findViewById(R.id.milkButton);
        cinnamon = findViewById(R.id.cinnamonButton);
        mayo = findViewById(R.id.mayoButton);
        brownSugar = findViewById(R.id.brownSugarButton);
        bakingPowder = findViewById(R.id.bakingPowderButton);
        vanilla = findViewById(R.id.vanillaButton);
        butter = findViewById(R.id.Butter);
        chili= findViewById(R.id.ChilipowderButton);
        egg = findViewById(R.id.egg);
        pepper = findViewById(R.id.PepperButton);
        cilantro = findViewById(R.id.CilantroButton);
        flour = findViewById(R.id.flourButton);
        honey = findViewById(R.id.HoneyButton);
        chiliF = findViewById(R.id.ChiliFlakesButton);
        salt = findViewById(R.id.SaltButton);
        cumin = findViewById(R.id.CuminButton);
        pbutter = findViewById(R.id.PeanutbutterButton);
        soysauce = findViewById(R.id.SoysauceButton);
        sugar = findViewById(R.id.SugarButton);
        vinagrette = findViewById(R.id.VinagretteDressingButton);
        broth = findViewById(R.id.BrothButton);
        oregano = findViewById(R.id.OreganoButton);
        basil = findViewById(R.id.BasilButton);
        oliveoil = findViewById(R.id.OliveoilButton);

        //grains linking buttons variables to the buttons
        bread = findViewById(R.id.BreadButton);
        oats = findViewById(R.id.OatsButton);
        grits = findViewById(R.id.GritsButton);
        barley = findViewById(R.id.BarleyButton);
        risotto = findViewById(R.id.RisottoButton);
        puffPastry = findViewById(R.id.PuffPastryButton);
        toast = findViewById(R.id.ToastButton);
        wholeGrainWrap = findViewById(R.id.WholeGrainWrapButton);
        spaghetti = findViewById(R.id.SpaghettiButton);
        granola = findViewById(R.id.granolaButton);
        rice = findViewById(R.id.RiceButton);
        quinoa = findViewById(R.id.QuinoaButton);

        //veggies linking buttons variables to the buttons
        lime = findViewById(R.id.LimeButton);
        cucumber = findViewById(R.id.CucumberButton);
        avocado = findViewById(R.id.AvocadoButton);
        onion = findViewById(R.id.OnionButton);
        carrot = findViewById(R.id.CarrotButton);
        veggieMix = findViewById(R.id.VegetablesMixedButton);
        celery = findViewById(R.id.CeleryButton);
        driedLentils = findViewById(R.id.DriedLentilsButton);
        tomato = findViewById(R.id.TomatoButton);
        cannedTomatoes = findViewById(R.id.CannedTomatosButton);
        bellPepper = findViewById(R.id.BellpepperButton);
        blackBeans = findViewById(R.id.BlackbeansButton);
        potato = findViewById(R.id.potato);
        ginger = findViewById(R.id.GingerButton);
        garlic = findViewById(R.id.GarlicButton);
        lettuce = findViewById(R.id.LettuceButton);

        //proteins linking buttons variables to the buttons
        greekYogurt = findViewById(R.id.GreekyogurtButton);
        cheese = findViewById(R.id.CheeseButton);
        chicken = findViewById(R.id.ChickenButton);
        almondMilk = findViewById(R.id.AlmondMilk);
        hummus = findViewById(R.id.HummusButton);
        salmon = findViewById(R.id.SalmonButton);
        groundBeef = findViewById(R.id.GroundBeefButton);

        //fruit linking buttons variables to the buttons
        frzbanana = findViewById(R.id.FrozenBananaButton);
        frzberries = findViewById(R.id.FrozenBerriesButton);

        //please add onclick listeners for all buttons for food here
        //onClick listener for basics
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        cinnamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        brownSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        bakingPowder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        butter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        chili.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        egg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        pepper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        cilantro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        flour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        honey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        chiliF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        salt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        cumin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        pbutter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        soysauce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        sugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        vinagrette.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        broth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        oregano.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        basil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        oliveoil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        //onClick listener for basics
        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        oats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        grits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        barley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        risotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        puffPastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        wholeGrainWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        spaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        granola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        quinoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //onClick listener for veggies
        lime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        avocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        veggieMix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        celery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        driedLentils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        cannedTomatoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        bellPepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        blackBeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        ginger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        garlic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //onClick listener for protein
        greekYogurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        almondMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        hummus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        groundBeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //onClick listener for fruit
        frzbanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        frzberries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

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