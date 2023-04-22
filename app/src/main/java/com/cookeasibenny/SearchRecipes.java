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
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.avocadotoast, "Avocado Toast",getResources().getString(com.cookeasibenny.R.string.avocado_toast)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.yogurt, "Yogurt Parfait",getResources().getString(com.cookeasibenny.R.string.yogurt_parfait)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.pbsmoothie, "peanut butter banana smoothie",getResources().getString(com.cookeasibenny.R.string.peanut_butter_banana_smoothie)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.chickensalad, "Grilled Chicken Salad",getResources().getString(com.cookeasibenny.R.string.grilled_chicken_salad)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.lentil_soup_3738547_960_720, "Lentil Soup",getResources().getString(com.cookeasibenny.R.string.lentil_soup)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.salmon_5371963_960_720, "Baked Salmon",getResources().getString(com.cookeasibenny.R.string.baked_salmon)));
        items.add(new itemRecipe(com.cookeasibenny.R.drawable.spaghetti_787048_960_720, "Spaghetti Bolognese",getResources().getString(com.cookeasibenny.R.string.spaghetti_bolognese)));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.food_wraps_3154084_960_720, "Veggie Wrap",getResources().getString(com.cookeasibenny.R.string.veggie_wrap)));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.quinoa_2986706_960_720, "Quinoa and black_beans",getResources().getString(com.cookeasibenny.R.string.quinoa_and_black_bean)));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "TestCase","the best test ever"));
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
