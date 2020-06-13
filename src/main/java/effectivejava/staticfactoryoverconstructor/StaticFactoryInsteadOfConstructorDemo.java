package effectivejava.staticfactoryoverconstructor;

import java.util.HashMap;

public class StaticFactoryInsteadOfConstructorDemo {

    public static void demo1() {

        HashMap<String, Integer> stringIntegerHashMap = CustomHashMap.newInstance();
        HashMap<String, String> stringStringHashMap = CustomHashMap.newInstance();

        stringIntegerHashMap.put("Test",1);
        stringStringHashMap.put("Hello", "World");

        stringIntegerHashMap.entrySet().forEach(System.out::println);
        stringStringHashMap.entrySet().forEach(System.out::println);

    }

    public static void demo2() {

        // It is referring to static factory object

        Boolean aTrue = Boolean.valueOf("true");
        Boolean bTrue = Boolean.valueOf("true");

        System.out.println(aTrue == bTrue); // prints true

        //since we are creating new Object every time, the references are not equal

        Boolean aTrue1 = new Boolean("true"); // this is deprecated after v9
        Boolean aTrue2 = new Boolean("true"); // this is deprecated after v9
        System.out.println(aTrue1 == aTrue2); // prints false

    }



}
