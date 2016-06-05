/**
 * Created by hungtran on 6/5/16.
 */
public class Abc {
    private static Abc ourInstance = new Abc();

    public static Abc getInstance() {
        return ourInstance;
    }

    private Abc() {
    }
}
