package effectivejava.creatingdestroyingobjects.singleton;

public class Elvis {

    public static final Elvis Instance = new Elvis(); //singleton with public final keyword

    private Elvis() {

    }

    public void leaveTheBuilding() {

    }
}

