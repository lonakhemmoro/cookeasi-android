package com.cookeasibenny;

import androidx.transition.Slide;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.transition.Transition;
import android.view.Gravity;
import android.widget.Toast;
import android.content.Intent;
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

private FridgeItinerary fridgeItinerary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dont mess w this line, connects the xml to the java
        setContentView(R.layout.activity_add_fridge);

        //retrieve instance of FridgeIteinerary
        fridgeItinerary = FridgeItinerary.getInstance();

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

        backtoFridge = (Button) findViewById(com.cookeasibenny.R.id.AddF_backFridge);
        BackToMenu = (Button) findViewById(com.cookeasibenny.R.id.AddF_BackMenu);

        //onclick listeners for bottom navigation
        backtoFridge.setOnClickListener(new View.OnClickListener(){
            public void onClick(View x){
            BackFridge();
            }
        });

        BackToMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View x){
            BackMenu();
            }
        });

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
                fridgeItinerary.addIngredient("milk", true);
                Toast.makeText(AddFridgeActivity.this, "milk added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        cinnamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("cinnamon", true);
                Toast.makeText(AddFridgeActivity.this, "cinnamon added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        mayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("mayo", true);
                Toast.makeText(AddFridgeActivity.this, "mayo added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        brownSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("brown sugar", true);
                Toast.makeText(AddFridgeActivity.this, "brown sugar added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        bakingPowder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("baking powder", true);
                Toast.makeText(AddFridgeActivity.this, "baking powder added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("vanilla", true);
                Toast.makeText(AddFridgeActivity.this, "vanilla added to fridge", Toast.LENGTH_SHORT).show();
            }
        });
        butter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("butter", true);
                Toast.makeText(AddFridgeActivity.this, "butter added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        chili.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("chili powder", true);
                Toast.makeText(AddFridgeActivity.this, "chili powder added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        egg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("egg", true);
                Toast.makeText(AddFridgeActivity.this, "egg added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        pepper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("pepper", true);
                Toast.makeText(AddFridgeActivity.this, "pepper added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        cilantro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("cilantro", true);
                Toast.makeText(AddFridgeActivity.this, "cilantro added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        flour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("flour", true);
                Toast.makeText(AddFridgeActivity.this, "flour added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        honey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("honey", true);
                Toast.makeText(AddFridgeActivity.this, "honey added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        chiliF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("chili flakes", true);
                Toast.makeText(AddFridgeActivity.this, "chili flakes added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        salt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("salt", true);
                Toast.makeText(AddFridgeActivity.this, "salt added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        cumin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("cumin", true);
                Toast.makeText(AddFridgeActivity.this, "cumin added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        pbutter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("peanut butter", true);
                Toast.makeText(AddFridgeActivity.this, "peanut butter added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        soysauce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("soy sauce", true);
                Toast.makeText(AddFridgeActivity.this, "soy sauce added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        sugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("sugar", true);
                Toast.makeText(AddFridgeActivity.this, "sugar added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        vinagrette.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("vinagrette dressing", true);
                Toast.makeText(AddFridgeActivity.this, "vinagrette dressing added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        broth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("broth", true);
                Toast.makeText(AddFridgeActivity.this, "broth added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        oregano.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("oregano", true);
                Toast.makeText(AddFridgeActivity.this, "oregano added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        basil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("basil", true);
                Toast.makeText(AddFridgeActivity.this, "basil added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        oliveoil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fridgeItinerary.addIngredient("olive oil", true);
                Toast.makeText(AddFridgeActivity.this, "olive oil added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        //onClick listener for basics
        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("bread", true);
                Toast.makeText(AddFridgeActivity.this, "bread added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        oats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("oats", true);
                Toast.makeText(AddFridgeActivity.this, "oats added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        grits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("grits", true);
                Toast.makeText(AddFridgeActivity.this, "grits added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        barley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("barley", true);
                Toast.makeText(AddFridgeActivity.this, "barley added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        risotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("risotto", true);
                Toast.makeText(AddFridgeActivity.this, "risotto added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        puffPastry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("puff pastry", true);
                Toast.makeText(AddFridgeActivity.this, "puff pastry added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("toast", true);
                Toast.makeText(AddFridgeActivity.this, "toast added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        wholeGrainWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("whole grain wrap", true);
                Toast.makeText(AddFridgeActivity.this, "whole grain wrap added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        spaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("spaghetti", true);
                Toast.makeText(AddFridgeActivity.this, "spaghetti added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        granola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("granola", true);
                Toast.makeText(AddFridgeActivity.this, "granola added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("rice", true);
                Toast.makeText(AddFridgeActivity.this, "rice added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        quinoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("quinoa", true);
                Toast.makeText(AddFridgeActivity.this, "quinoa added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        //onClick listener for veggies
        lime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("lime", true);
                Toast.makeText(AddFridgeActivity.this, "lime added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("cucumber", true);
                Toast.makeText(AddFridgeActivity.this, "cucumber added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        avocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("avocado", true);
                Toast.makeText(AddFridgeActivity.this, "avocado added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("onion", true);
                Toast.makeText(AddFridgeActivity.this, "onion added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("carrot", true);
                Toast.makeText(AddFridgeActivity.this, "carrot added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        veggieMix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("vegetables mixed", true);
                Toast.makeText(AddFridgeActivity.this, "vegetables mixed added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        celery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("celery", true);
                Toast.makeText(AddFridgeActivity.this, "celery added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        driedLentils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("dried lentils", true);
                Toast.makeText(AddFridgeActivity.this, "dried lentils added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("tomato", true);
                Toast.makeText(AddFridgeActivity.this, "tomato added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        cannedTomatoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("canned tomatoes", true);
                Toast.makeText(AddFridgeActivity.this, "canned tomatoes added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        bellPepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("bell pepper", true);
                Toast.makeText(AddFridgeActivity.this, "bell pepper added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        blackBeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("black beans", true);
                Toast.makeText(AddFridgeActivity.this, "black beans added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("potato", true);
                Toast.makeText(AddFridgeActivity.this, "potato added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        ginger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("ginger", true);
                Toast.makeText(AddFridgeActivity.this, "ginger added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        garlic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("garlic", true);
                Toast.makeText(AddFridgeActivity.this, "garlic added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("lettuce", true);
                Toast.makeText(AddFridgeActivity.this, "lettuce added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        //onClick listener for protein
        greekYogurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("greek yogurt", true);
                Toast.makeText(AddFridgeActivity.this, "greek yogurt added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("cheese", true);
                Toast.makeText(AddFridgeActivity.this, "cheese added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("chicken", true);
                Toast.makeText(AddFridgeActivity.this, "chicken added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        almondMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("almond milk", true);
                Toast.makeText(AddFridgeActivity.this, "almond milk added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        hummus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("hummus", true);
                Toast.makeText(AddFridgeActivity.this, "hummus added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("salmon", true);
                Toast.makeText(AddFridgeActivity.this, "salmon added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        groundBeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("ground beef", true);
                Toast.makeText(AddFridgeActivity.this, "ground beef added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        //onClick listener for fruit
        frzbanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("frozen banana", true);
                Toast.makeText(AddFridgeActivity.this, "frozen banana added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        frzberries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fridgeItinerary.addIngredient("frozen berries", true);
                Toast.makeText(AddFridgeActivity.this, "frozen berries added to fridge", Toast.LENGTH_SHORT).show();
            }
        });

        //add food buttons above.
    }

    private void BackMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void BackFridge() {
        Intent intent = new Intent(this, FridgeActivity.class);
        startActivity(intent);
    }

    //public voids for visiiblity of food groups for buttons
    //all but visibilityBasics are empty, but that is the example, change R.id.BasicsCollapse to
    //respective collapse layout
    private void VisibilityGrains() {
        android.view.ViewGroup Basics = findViewById(R.id.GrainsCollapse);
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

    public void VisibilityFruit() {
        android.view.ViewGroup Basics = findViewById(R.id.FruitCollapse);
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

    public void VisibilityProtein() {
        android.view.ViewGroup Basics = findViewById(R.id.ProteinCollapse);
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

    public void VisibilityVegetables() {
        android.view.ViewGroup Basics = findViewById(R.id.VegetableCollapse);
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