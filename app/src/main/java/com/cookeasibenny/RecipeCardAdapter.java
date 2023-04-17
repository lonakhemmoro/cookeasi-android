package com.cookeasibenny;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Callback;

public class RecipeCardAdapter extends RecyclerView.Adapter<RecipeCardAdapter.RecipeViewHolder> {
    private ArrayList<Recipe.Result> recipeList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        public ImageView recipeImage;
        public TextView recipeTitle;
        public Button viewRecipeButton;

        public RecipeViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.recipe_image);
            recipeTitle = itemView.findViewById(R.id.recipe_title);
            viewRecipeButton = itemView.findViewById(R.id.view_recipe_button);

            viewRecipeButton.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    public RecipeCardAdapter(Callback<Recipe.Root> callback, ArrayList<Recipe.Result> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new RecipeViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe.Result currentItem = recipeList.get(position);
        holder.recipeTitle.setText(currentItem.title);
        Glide.with(holder.itemView.getContext()).load(currentItem.image).into(holder.recipeImage);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
