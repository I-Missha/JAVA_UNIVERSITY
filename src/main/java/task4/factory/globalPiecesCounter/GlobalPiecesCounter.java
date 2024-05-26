package task4.factory.globalPiecesCounter;

public class GlobalPiecesCounter {
    static int globalPiecesCounter = 0;

    synchronized public static int nexId() {
        globalPiecesCounter++;
        return globalPiecesCounter;
    }
}
