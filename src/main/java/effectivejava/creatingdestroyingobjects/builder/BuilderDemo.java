package effectivejava.creatingdestroyingobjects.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        NutritionFacts build = new NutritionFacts.Builder(1, 2)
                                                .calories(1)
                                                .carbohydrate(2)
                                                .sodium(2)
                                                .fat(3)
                                                .build();
        System.out.println(build);
    }
}
