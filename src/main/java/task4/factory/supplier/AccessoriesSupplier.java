package task4.factory.supplier;

import task4.factory.globalPiecesCounter.GlobalPiecesCounter;
import task4.factory.pieces.Accessory;
import task4.factory.pieces.Piece;
import task4.factory.storage.Storage;

public class AccessoriesSupplier extends Supplier {
    public AccessoriesSupplier(Storage<Piece> st, int workTime) {
        super(st, workTime);
    }

    @Override
    public void createAndStorePiece() {
        try {
            sleep(workTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        storage.addPiece(new Accessory(GlobalPiecesCounter.nexId()));
    }
}
