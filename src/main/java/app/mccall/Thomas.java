package app.mccall;

/**
 * Hello world!
 *
 */
public class Thomas {

    static Thomas instance = null;

    private Thomas() {

    }

    public static Thomas getInstance() {
        if (instance == null)
            instance = new Thomas();
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
