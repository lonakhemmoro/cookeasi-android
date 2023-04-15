
package com.cookeasibenny;

import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderRecipe extends RecyclerView.ViewHolder {

    ImageView imageView1;
    TextView textView1;
    TextView textView2;

    public ViewHolderRecipe(android.view.View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(com.cookeasibenny.R.id.imageView1);
        textView1 = itemView.findViewById(com.cookeasibenny.R.id.Title);
        textView2 = itemView.findViewById(com.cookeasibenny.R.id.subheaderReicpe);


    }
}