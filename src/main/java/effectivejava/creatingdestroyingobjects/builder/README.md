## Item2 : Consider builder when faced with many constructor parameters

Static factories and constructors share a limitation: they do not scale well to largenumbers of optional parameters. Consider the case of a class representing theNutrition Facts label that appears on packaged foods.

### Telescoping Pattern

```java
public class NutritionFactsT {
    private final int servingSize;  // (mL)required
    private final int servings;     // (per container) required
    private final int calories;     // (per serving)   optional
    private final int fat;// (g/serving)     optional
    private final int sodium;       // (mg/serving)    optional
    private final int carbohydrate; // (g/serving)     optional

    public NutritionFactsT(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFactsT(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFactsT(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFactsT(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFactsT(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
```

When you want to create an instance, you use the constructor with the shortest parameter list containing all the parameters you want to set

```java
NutritionFacts cocaCola =new NutritionFacts(240, 8, 100, 0, 35, 27);
```

the telescoping constructor pattern works, but it is hard to writeclient code when there are many parameters, and harder still to read it

Long sequences of identically typed parameters can causesubtle bugs. If the client accidentally reverses two such parameters, the compilerwon’t complain, but the program will misbehave at runtime

### Java Beans Pattern

```java
public class NutritionFactsBeansPattern {    
    private int servingSize;  // (mL)required
    private int servings;     // (per container) required
    private int calories;     // (per serving)   optional
    private int fat;// (g/serving)     optional
    private int sodium;       // (mg/serving)    optional
    private int carbohydrate; // (g/serving)     optional

    public NutritionFactsBeansPattern() {

    }

}

NutritionFactsBeansPattern beansPattern = new NutritionFactsBeansPattern();
        beansPattern.setCalories(1);
        beansPattern.setCarbohydrate(2);
        beansPattern.setFat(3);
        beansPattern.setServings(1);
        beansPattern.setServingSize(1);
        beansPattern.setCalories(1);
```

- the JavaBeans pattern precludes the possibility of making a class immutable
- a JavaBean may be in an inconsistent state partway through its construction
- Validity checks were omitted for brevity. To detect invalid parameters as soon as possible, check parameter validity in the builder’s constructor and methods.Check invariants involving multiple parameters in the constructor invoked by the build method. To ensure these invariants against attack, do the checks on object fields after copying parameters from the builder. If a check fails, throw an IllegalArgumentException whose detail message indicates which parameters are invalid

### Builder Pattern

```java
private int servingSize;  // (mL)required
    private int servings;     // (per container) required
    private int calories;     // (per serving)   optional
    private int fat;// (g/serving)     optional
    private int sodium;       // (mg/serving)    optional
    private int carbohydrate; // (g/serving)     optional

    private NutritionFacts(Builder builder) {
        this.servings = builder.servings;
        this.servingSize = builder.servingSize;
        this.calories = builder.calories;
        this.carbohydrate = builder.carbohydrate;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        //required parameters
        private int servingSize;
        private int servings;

        //optional parameters
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

NutritionFacts build = new NutritionFacts.Builder(1, 2)
                                          .calories(1)
                                          .carbohydrate(2)
                                          .sodium(2)
                                          .fat(3)
                                          .build();
```

### Advantages

- More verbose
- client code is easy to write and, more importantly, easy to read
- The Builderpattern simulates named optional parameters

### Disadvantages

- The Builder pattern has disadvantages as well. In order to create an object, you must first create its builder. While the cost of creating this builder is unlikely to be noticeable in practice, it could be a problem in performance-critical situations

### Note

**The Builder pattern is a good choice when designing classeswhose constructors or static factories would have more than a handful ofparameters**

The Builder pattern is more verbose than the telescoping constructor pattern,so it should be used only if there are enough parameters to make it worthwhile, say four or more. But keep in mind that you may want to add more parameters in the future. But if you start out with constructors or static factories and switch to a builder when the class evolves to the point where the number of parameters gets out of hand, the obsolete constructors or static factories will stick out like a sore thumb. Therefore, it’s often better to start with a builder in the first place