
package com.cookeasibenny;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ViewHolderRecipe extends RecyclerView.ViewHolder {

    ImageView imageView1;
    TextView textView1;
    TextView textView2;
    Button MakeItBtn1;

    TextView Directions;
    public ViewHolderRecipe(android.view.View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(com.cookeasibenny.R.id.imageView1);
        textView1 = itemView.findViewById(com.cookeasibenny.R.id.Title);
        textView2 = itemView.findViewById(com.cookeasibenny.R.id.subheaderReicpe);
        MakeItBtn1 = itemView.findViewById(com.cookeasibenny.R.id.MakeItBtn);
        Directions = itemView.findViewById(com.cookeasibenny.R.id.Directions);

      textView1.setOnClickListener(new android.view.View.OnClickListener() {
          @Override
          public void onClick(android.view.View v) {
              OnclickRecipePage();
          }
      });


    }

    public void OnclickRecipePage() {
        android.content.Intent openRecipeIntent = new android.content.Intent(itemView.getContext(), RecipePage1.class);
        openRecipeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        itemView.getContext().startActivity(openRecipeIntent);
    }


}