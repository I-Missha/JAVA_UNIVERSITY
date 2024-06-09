package task4.factory.Storages;

import task4.factory.BlockingQueueModel.BlockingQueue;

import java.util.Objects;

public class Storage<T> extends BlockingQueue<T> {

    protected int totalProduced = 0;

    public Storage(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentSize() {
        return queue.size();
    }

    public boolean isFull() {
        return queue.size() == capacity;
    }

    public int getTotalProduced() {
        return totalProduced;
    }


    @Override
    synchronized public void put(T el) {
        super.put(el);
        totalProduced++;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Storage<?> storage = (Storage<?>) object;
        return capacity == storage.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }

}
