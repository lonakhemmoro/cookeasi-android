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
                    startActivity(intent);
                }
                else {
                    intent.putExtra("recipe_name", filteredList.get(position).getSubtext());
                    startActivity(intent);
                }
            }
        };
    }

    public void ExampleList(){
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Avocado Toast",getResources().getString(com.cookeasibenny.R.string.avocado_toast)));
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Yogurt Parfait",getResources().getString(com.cookeasibenny.R.string.yogurt_parfait)));
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "peanut butter banana smoothie",getResources().getString(com.cookeasibenny.R.string.peanut_butter_banana_smoothie)));
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Grilled Chicken Salad",getResources().getString(com.cookeasibenny.R.string.grilled_chicken_salad)));
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Lentil Soup",getResources().getString(com.cookeasibenny.R.string.lentil_soup)));
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Baked Salmon",getResources().getString(com.cookeasibenny.R.string.baked_salmon)));
        items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Spaghetti Bolognese",getResources().getString(com.cookeasibenny.R.string.spaghetti_bolognese)));
    items.add(new itemRecipe(com.cookeasibenny.R.string.recipe_example, "Veggie Wrap",getResources().getString(com.cookeasibenny.R.string.veggie_wrap)));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "Quinoa and black_beans",getResources().getString(com.cookeasibenny.R.string.quinoa_and_black_bean)));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "T","the best test ever"));
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
                    if(item.getTitle().toLowerCase().contains(s.toLowerCase()))
                    {
                        filteredList.add(item);
                    }
                }

                AdapterRecipe itemAdapter = new AdapterRecipe(getApplicationContext(),filteredList, items, listener);
                RecyclerView recyclerView = findViewById(com.cookeasibenny.R.id.searchRecycler);
                recyclerView.setAdapter(itemAdapter);

                return false;
            }
        });

}}
