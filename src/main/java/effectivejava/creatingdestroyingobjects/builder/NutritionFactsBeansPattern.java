package effectivejava.creatingdestroyingobjects.builder;

public class NutritionFactsBeansPattern {

    private int servingSize;  // (mL)required
    private int servings;     // (per container) required
    private int calories;     // (per serving)   optional
    private int fat;// (g/serving)     optional
    private int sodium;       // (mg/serving)    optional
    private int carbohydrate; // (g/serving)     optional

    public NutritionFactsBeansPattern() {

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void demo() {
        NutritionFactsBeansPattern beansPattern = new NutritionFactsBeansPattern();
        beansPattern.setCalories(1);
        beansPattern.setCarbohydrate(2);
        beansPattern.setFat(3);
        beansPattern.setServings(1);
        beansPattern.setServingSize(1);
        beansPattern.setCalories(1);
    }
}
