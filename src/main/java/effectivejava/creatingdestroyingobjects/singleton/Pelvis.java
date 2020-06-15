package effectivejava.creatingdestroyingobjects.singleton;

public class Pelvis{
    private static final Pelvis Instance = new Pelvis();

    private Pelvis() {

    }

    //singleton with static factory

    public static Pelvis getInstance() {
        return Instance;
    }

    public void leaveTheBuilding() {

    }
}
