package effectivejava.staticfactoryoverconstructor;

import java.util.HashMap;

public class CustomHashMap {

    //creating static factory method to instantiate map of required type

    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<>();
    }
}
