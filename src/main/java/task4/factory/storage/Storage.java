package task4.factory.storage;

import task4.factory.ThreadSafeBuffer.ThreadSafeBuffer;

public class Storage<pieceType> extends ThreadSafeBuffer<pieceType> {
//    total produced - ??

    public Storage(int maxSize) {
        super(maxSize);
    }


}
