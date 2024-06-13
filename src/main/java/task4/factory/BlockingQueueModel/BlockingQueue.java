package task4.factory.BlockingQueueModel;

import java.util.LinkedList;

public class BlockingQueue<T> {

    protected LinkedList<T> queue;
    protected int capacity = Integer.MAX_VALUE;
    public BlockingQueue() {
        this.queue = new LinkedList<>();
    }

    synchronized public T get() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        T el = queue.pop();
        notify();
        return el;
    }

    protected boolean isFull() {
        return queue.size() == capacity;
    }

    public int getCurrentSize() {
        return queue.size();
    }
    synchronized public void put(T el) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(el);
        notify();
    }

}