package com.cookeasibenny;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AdapterRecipe extends RecyclerView.Adapter<ViewHolderRecipe> {
private RecyclerViewClickListener listener;


    Context context;
    List<itemRecipe> items;
    List<itemRecipe> filteredList;
    private java.util.List<com.cookeasibenny.itemRecipe> itemList;


    public AdapterRecipe(android.content.Context context, java.util.List<com.cookeasibenny.itemRecipe> items, java.util.List<itemRecipe> filteredList, com.cookeasibenny.AdapterRecipe.RecyclerViewClickListener listener) {
        this.context = context;
        this.items = items;
        this.itemList = itemList;
        this.listener = listener;
        this.filteredList = filteredList;
    }



    @androidx.annotation.NonNull
    public com.cookeasibenny.ViewHolderRecipe onCreateViewHolder(@androidx.annotation.NonNull android.view.ViewGroup parent, int viewType) {
        return new ViewHolderRecipe(LayoutInflater.from(context).inflate(com.cookeasibenny.R.layout.recipes_itme,parent,false),listener);
    }

    @Override
    public void onBindViewHolder( ViewHolderRecipe holder, int position) {
        holder.textView1.setText(items.get(position).getTitle());
        holder.textView2.setText(items.get(position).getSubtext());
        holder.imageView1.setImageResource(items.get(position).getImage());

    }

    @Override
    public int getItemCount() {
         return items.size();
    }
    public void updateList(List<itemRecipe> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }
public interface RecyclerViewClickListener{
        void onClick(android.view.View v, int position);
}


}