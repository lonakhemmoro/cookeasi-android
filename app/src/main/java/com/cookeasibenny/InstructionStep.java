/*package com.cookeasibenny;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class InstructionStep {
    private String step;
    private List<String> ingredients;

    public InstructionStep(String step, List<String> ingredients) {
        this.step = step;
        this.ingredients = ingredients;
    }

    public String getStep() {
        return step;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static List<InstructionStep> parseJSON(String jsonString) {
        List<InstructionStep> steps = new ArrayList<>();
        JSONArray stepsArray = new JSONArray(jsonString);
        for (int i = 0; i < stepsArray.length(); i++) {
            JSONObject stepObject = stepsArray.getJSONObject(i);
            JSONArray stepArray = stepObject.getJSONArray("steps");
            for (int j = 0; j < stepArray.length(); j++) {
                JSONObject stepData = stepArray.getJSONObject(j);
                String stepText = stepData.getString("step");
                JSONArray ingredientArray = stepData.getJSONArray("ingredients");
                List<String> ingredientList = new ArrayList<>();
                for (int k = 0; k < ingredientArray.length(); k++) {
                    JSONObject ingredientData = ingredientArray.getJSONObject(k);
                    String ingredientName = ingredientData.getString("name");
                    ingredientList.add(ingredientName);
                }
                steps.add(new InstructionStep(stepText, ingredientList));
            }
        }
        return steps;
    }
}
//example usage
/*
String jsonString = "[{...}]"; // JSON data here
List<InstructionStep> steps = InstructionStep.parseJSON(jsonString);
for (InstructionStep step : steps) {
    System.out.println(step.getStep());
    System.out.println(step.getIngredients());
}

 */

//example output
/*
Step 1: Preheat the oven to 200 degrees F.

Equipment: oven
Temperature: 200.0 Fahrenheit
Ingredients: None
Step 2: Whisk together the flour, pecans, granulated sugar, light brown sugar, baking powder, baking soda, and salt in a medium bowl.

Equipment: whisk, bowl
Ingredients:
all purpose flour
pecans
granulated sugar
light brown sugar
baking powder
baking soda
salt
Step 3: Whisk together the eggs, buttermilk, butter and vanilla extract and vanilla bean in a small bowl.

Equipment: whisk, bowl
Ingredients:
eggs
buttermilk
butter
vanilla extract
vanilla bean
Step 4: Add the egg mixture to the dry mixture and gently mix to combine. Do not overmix.

Equipment: None
Ingredients:
eggs
all purpose flour
pecans
granulated sugar
light brown sugar
baking powder
baking soda
salt
butter
vanilla extract
vanilla bean
Step 5: Let the batter sit at room temperature for at least 15 minutes and up to 30 minutes before using.

Equipment: None
Ingredients: None
Length: 15 minutes
Step 6: Heat a cast iron or nonstick griddle pan over medium heat and brush with melted butter. Once the butter begins to sizzle, use 2 tablespoons of the batter for each pancake and cook until the bubbles appear on the surface and the bottom is golden brown, about 2 minutes, flip over and cook until the bottom is golden brown, 1 to 2 minutes longer.

Equipment: griddle, frying pan
Ingredients:
eggs
all purpose flour
pecans
granulated sugar
light brown sugar
baking powder
baking soda
salt
butter
vanilla extract
vanilla bean
Step 7: Transfer the pancakes to a platter and keep warm in a 200 degree F oven.

Equipment: oven
Temperature: 200.0 Fahrenheit
Ingredients: None
 */

