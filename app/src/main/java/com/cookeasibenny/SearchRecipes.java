package com.cookeasibenny;

import static com.cookeasibenny.R.menu.menu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;
import android.view.MenuItem;
import androidx.core.view.MenuItemCompat;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;

import com.cookeasibenny.R.menu;

public class SearchRecipes extends AppCompatActivity  {
    List<itemRecipe> items = new ArrayList<itemRecipe>();
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipes);
ExampleList();









        RecyclerView recyclerView = findViewById(com.cookeasibenny.R.id.searchRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterRecipe(getApplicationContext(),items));

    }
private void ExampleList(){
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "R","the best test ever"));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "S","the best test ever"));
    items.add(new itemRecipe(com.cookeasibenny.R.drawable.fridge_image_svg, "T","the best test ever"));
}

}
