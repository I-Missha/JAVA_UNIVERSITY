package task4.factory;


public class IdsGenerator {

    private static long last = 0;
    synchronized public static long generateId() {
        return last++;
    }
}
