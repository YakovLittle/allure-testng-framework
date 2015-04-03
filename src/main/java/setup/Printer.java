package setup;

/**
 * Created by s.lugovskiy on 20.03.2015 15:36.
 */
public class Printer {
    public static void println(String txt) {
        System.out.println("THREAD " + Thread.currentThread().getId() + ": " + txt);
    }
}