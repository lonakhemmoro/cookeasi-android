package com.cookeasibenny;

import static com.cookeasibenny.R.menu.menu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.List;
import android.view.MenuItem;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;

import com.cookeasibenny.R.menu;

public class SearchRecipes extends AppCompatActivity  {
    List<itemRecipe> items = new ArrayList<itemRecipe>();
    List<itemRecipe> filteredList = new ArrayList<itemRecipe>();
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);
        ExampleList();









        RecyclerView recyclerView = findViewById(com.cookeasibenny.R.id.searchRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterRecipe(getApplicationContext(),items));
initSearchWidget();
    }
private void ExampleList(){
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "R","the best test ever"));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "S","the best test ever"));
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
                filteredList.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "R","the best test ever"));
                for(itemRecipe item : items)
                {
                    if(item.getTitle().toLowerCase().contains(s.toLowerCase()))
                    {
                        filteredList.add(item);
                    }
                }

                AdapterRecipe itemAdapter = new AdapterRecipe(getApplicationContext(),filteredList);
                RecyclerView recyclerView = findViewById(com.cookeasibenny.R.id.searchRecycler);
                recyclerView.setAdapter(itemAdapter);
                return false;
            }
        });

}}
