
package com.cookeasibenny;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import  android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
public class ViewHolderRecipe extends RecyclerView.ViewHolder {

    ImageView imageView1;
    TextView textView1;
    TextView textView2;

    Button MakeItBtn1;

    public ViewHolderRecipe(android.view.View itemView) {
        super(itemView);
        imageView1 = itemView.findViewById(com.cookeasibenny.R.id.imageView1);
        textView1 = itemView.findViewById(com.cookeasibenny.R.id.Title);
        textView2 = itemView.findViewById(com.cookeasibenny.R.id.subheaderReicpe);
        MakeItBtn1 = itemView.findViewById(com.cookeasibenny.R.id.MakeItBtn);
MakeItBtn1.setOnClickListener(new android.view.View.OnClickListener() {
    @Override
    public void onClick(android.view.View v) {
        ClickIntent();
    }
});
    }

    public void ClickIntent(){

    }

}