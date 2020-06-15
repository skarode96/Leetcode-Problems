package effectivejava.creatingdestroyingobjects.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        Elvis elvisInstance = Elvis.Instance;
        Pelvis pelvisInstance = Pelvis.getInstance();
    }

}
