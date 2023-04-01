package com.cookeasibenny;
//this is the get method for our recipe data. this just holds the data for the array in the searchrecipes
//java class

public class RecipeData {
    private int rImage1;
     private String rTitletext1;
     private String rSubtext1;
//this is within the recipes_itme.xml, listing the image, title and subheader
     public RecipeData(int rImage1, String rTitletext1, String rSubtext1){
         rImage1 = rImage1;
         rTitletext1 = rTitletext1;
         rSubtext1 = rSubtext1;
     }


    public int getImage1(){
         return rImage1;
     }

    public String getrTitletext1() {
        return rTitletext1;
    }

    public String getrSubtext1() {
        return rSubtext1;
    }
}
