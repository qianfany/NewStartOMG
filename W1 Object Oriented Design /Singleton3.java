

public class Singleton3 {
    public static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }
    private Singleton3() {
        
    }
}
