package business.services.moves.pieces;

import business.services.moves.cardinal.ICalculateCardinalKnightMove;
import gui.ChessGameBoard;
import utils.IsOnScreen;

import java.util.ArrayList;
import java.util.List;

public class KnightMove {

    List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves;

    
    public KnightMove(List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves) {
        this.calculateCardinalKnightMoves = calculateCardinalKnightMoves;
    }

    public List<String> calculatePossibleMoves(ChessGameBoard board, int row, int column) {
        ArrayList<String> moves = new ArrayList<>();
        if (IsOnScreen.invoke(row, column)) {

            calculateCardinalKnightMoves.forEach(cardinalKnightMove -> moves.addAll(cardinalKnightMove.invoke(board)));

        }
        return moves;
    }

}
