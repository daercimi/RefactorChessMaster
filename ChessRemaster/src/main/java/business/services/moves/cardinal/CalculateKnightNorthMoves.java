package business.services.moves.cardinal;

import business.services.moves.cardinal.ICalculateCardinalKnightMove;
import gui.ChessGameBoard;
import utils.ColorOfPiece;
import utils.IsEnemy;
import utils.IsOnScreen;

import java.util.ArrayList;

public class CalculateKnightNorthMoves implements ICalculateCardinalKnightMove {
    private int pieceRow;
    private int pieceColumn;
    private ColorOfPiece colorOfPiece;

    public CalculateKnightNorthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();
        for (int i = 2; i >= -2; i -= 4) {
            for (int j = 1; j >= -1; j -= 2) {
                if (IsOnScreen.invoke(pieceRow + i, pieceColumn + j)
                        && (IsEnemy.invoke(board, pieceRow + i, pieceColumn + j,colorOfPiece.getColor()) ||
                        board.getCell(
                                pieceRow + i,
                                pieceColumn + j)
                                .getPieceOnSquare() == null)) {
                    moves.add((pieceRow + i) + "," + (pieceColumn + j));
                }
            }
        }
        return moves;
    }
}
