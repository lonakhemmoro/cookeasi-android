
package com.cookeasibenny;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ViewHolderRecipe extends RecyclerView.ViewHolder implements android.view.View.OnClickListener {

    ImageView imageView1;
    TextView textView1;
    TextView textView2;
    Button MakeItBtn1;
AdapterRecipe.RecyclerViewClickListener listener;

    public void setRecylerViewClickListener(com.cookeasibenny.AdapterRecipe.RecyclerViewClickListener listener) {
        this.listener = listener;
    }

    public ViewHolderRecipe(android.view.View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(com.cookeasibenny.R.id.imageView1);
        textView1 = itemView.findViewById(com.cookeasibenny.R.id.Title);
        textView2 = itemView.findViewById(com.cookeasibenny.R.id.subheaderReicpe);
        itemView.setOnClickListener(this);

}

    @Override
    public void onClick(android.view.View v) {
        if (listener != null) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }
}