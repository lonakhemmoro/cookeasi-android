package com.cookeasibenny;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderRecipe extends RecyclerView.ViewHolder implements android.view.View.OnClickListener {

    ImageView imageView1;
    TextView textView1;
    TextView textView2;
AdapterRecipe.RecyclerViewClickListener listener;

    public void setRecyclerViewClickListener(com.cookeasibenny.AdapterRecipe.RecyclerViewClickListener listener) {
this.listener = listener;
    }

    public ViewHolderRecipe(android.view.View itemView, com.cookeasibenny.AdapterRecipe.RecyclerViewClickListener listener) {
        super(itemView);
        imageView1 = itemView.findViewById(com.cookeasibenny.R.id.imageView1);
        textView1 = itemView.findViewById(com.cookeasibenny.R.id.Title);
        textView2 = itemView.findViewById(com.cookeasibenny.R.id.subheaderReicpe);
        itemView.setOnClickListener(this);
        this.listener = listener;

}

    @Override
    public void onClick(android.view.View v) {
        if (listener != null) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }
}