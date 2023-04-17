package com.cookeasibenny;

public class itemRecipe {
    public int Image;
    public String Title;
     public String Subtext;
    private String originalTitle;


    //this is within the recipes_itme.xml, listing the image, title and subheader
    public itemRecipe(int Image, String Title, String Subtext) {
        this.Image = Image;
        this.Title = Title;
        this.Subtext = Subtext;
        this.originalTitle = Subtext;
    }



    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }
    public String getOriginalTitle() {
        return originalTitle;
    }
    public String getSubtext() {
        return Subtext;
    }


}
