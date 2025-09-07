package designpatterns;

/**
 * Author: Artyom Aroyan
 * Date: 05.09.25
 * Time: 23:09:09
 */
public final class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}