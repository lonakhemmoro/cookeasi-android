package com.cookeasibenny;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class SearchRecipes extends AppCompatActivity  {
    List<itemRecipe> items = new ArrayList<itemRecipe>();
    List<itemRecipe> filteredList = new ArrayList<itemRecipe>();
// for the getstrings
    AdapterRecipe.RecyclerViewClickListener listener;

    Button backToMenu;
    Button goToFridge;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);
        ExampleList();

        backToMenu = findViewById(R.id.BackToMenu);
        goToFridge = findViewById(R.id.GoToFridge);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        goToFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FridgeActivity.class);
                startActivity(intent);
            }
        });





SetOnClick();
        RecyclerView recyclerView = findViewById(com.cookeasibenny.R.id.searchRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterRecipe(getApplicationContext(),items,filteredList,listener));
initSearchWidget();
    }

    private void SetOnClick() {
        listener = new com.cookeasibenny.AdapterRecipe.RecyclerViewClickListener() {
            @Override
            public void onClick(android.view.View v, int position) {
                Intent intent = new Intent(getApplicationContext(),RecipePage1.class);
                if(filteredList.isEmpty()){
                    intent.putExtra("recipe_name",items.get(position).getSubtext());
                    intent.putExtra("image",items.get(position).getImage());
                    intent.putExtra("title", items.get(position).getTitle());
                    startActivity(intent);
                }
                else {
                    intent.putExtra("recipe_name", filteredList.get(position).getSubtext());
                    intent.putExtra("title", filteredList.get(position).getTitle());
                    intent.putExtra("image",filteredList.get(position).getImage());
                    startActivity(intent);
                }
            }
        };
    }

   public void ExampleList(){
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Avocado Toast",getResources().getString(com.cookeasibenny.R.string.avocado_toast)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Yogurt Parfait",getResources().getString(com.cookeasibenny.R.string.yogurt_parfait)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "peanut butter banana smoothie",getResources().getString(com.cookeasibenny.R.string.peanut_butter_banana_smoothie)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Grilled Chicken Salad",getResources().getString(com.cookeasibenny.R.string.grilled_chicken_salad)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Lentil Soup",getResources().getString(com.cookeasibenny.R.string.lentil_soup)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Baked Salmon",getResources().getString(com.cookeasibenny.R.string.baked_salmon)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Spaghetti Bolognese",getResources().getString(com.cookeasibenny.R.string.spaghetti_bolognese)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Veggie Wrap",getResources().getString(com.cookeasibenny.R.string.veggie_wrap)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Quinoa and black_beans",getResources().getString(com.cookeasibenny.R.string.quinoa_and_black_bean)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Scrambled Eggs",getResources().getString(com.cookeasibenny.R.string.Scrambled_Eggs)));


    }

    private void initSearchWidget(){
        SearchView searchview = (SearchView)  findViewById(com.cookeasibenny.R.id.SearchView);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s){
            
                filteredList.clear();
                for(itemRecipe item : items)
                {
                    if (fridgeContents.containsAll(fridgeContents)) {
                        if (item.getTitle().toLowerCase().contains(s.toLowerCase())) {
                            filteredList.add(item);
                        }
                    }
                }
                
                /* CODE FOR EXTRA FUNCTIONALITY TO FILTER RECIPIES ------------------
                //plan to edit this code in our main 

 for (int i = 0; i < choice; i++)    //allows user to add all their ingredients
        {
        	System.out.println("Enter Ingredient #" + (i + 1)); //entering ingredient number X

        	String ingredient = IngredInput.nextLine();
        }
  for (int i = 0; i < ingred.length; i++)
        {
        	match = false;
            for (int j = 0; j < cookBook.recipeList.size(); j++)
            {
            	 String[] recipeIngredients = cookBook.recipeList.get(j).getIngredients();


                     if (ingred[i].equalsIgnoreCase(recipeIngredients[j]))
                     {
                    	 match = true;
		                System.out.println();
		                System.out.println("Based on your ingredients, you should make: \n" + cookBook.recipeList.get(j).getName() + "\n");



		                System.out.println("\nDIRECTIONS:");
		                System.out.println(cookBook.recipeList.get(j).getDirections());


		                break;
                    }


            } //extra code functionality ends ----------------------
            */

                AdapterRecipe itemAdapter = new AdapterRecipe(getApplicationContext(),filteredList, items, listener);
                RecyclerView recyclerView = findViewById(com.cookeasibenny.R.id.searchRecycler);
                recyclerView.setAdapter(itemAdapter);

                return false;
            }
        });

}}
