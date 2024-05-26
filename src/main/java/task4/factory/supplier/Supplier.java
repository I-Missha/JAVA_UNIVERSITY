package task4.factory.supplier;
import task4.factory.pieces.Piece;
import task4.factory.storage.Storage;

abstract class Supplier extends Thread {

    protected Storage<Piece> storage;
    protected int workTime;


    public Supplier(Storage<Piece> st, int time) {
        this.storage = st;
        this.workTime = time;
    }

    abstract void createAndStorePiece() throws InterruptedException;

    public void run() {
        while (true) {
            try {
                createAndStorePiece();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
