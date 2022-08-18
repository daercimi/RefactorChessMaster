package business.services.king;

import business.pieces.ChessGamePiece;
import java.io.Serializable;

public interface IKingService extends Serializable {

    boolean isChecked(ChessGamePiece piece);
}
