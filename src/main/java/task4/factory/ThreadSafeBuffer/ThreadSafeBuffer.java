package task4.factory.ThreadSafeBuffer;


import java.util.LinkedList;

public class ThreadSafeBuffer<pieceType> {
    protected LinkedList<pieceType> buff;
    int maxSize;

    public ThreadSafeBuffer(int maxSize) {
        this.buff = new LinkedList<>();
        this.maxSize = maxSize;
    }

    // size - might be a capacity, so here is a dangerous place

    synchronized public void addPiece(pieceType piece) {
        while (buff.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buff.add(piece);
        notify();
    }

    synchronized public pieceType getPiece() {
        while (buff.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        pieceType piece = buff.pop();
        notify();
        return piece;
    }
}
