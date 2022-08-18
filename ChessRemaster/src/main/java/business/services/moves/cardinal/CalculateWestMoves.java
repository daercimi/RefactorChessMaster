package business.services.moves.cardinal;

import java.util.ArrayList;

import gui.ChessGameBoard;
import utils.ColorOfPiece;

public class CalculateWestMoves extends CalculateCardinalMoves {
  public CalculateWestMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
    super(pieceRow,pieceColumn,colorOfPiece);
  }
  
  // TODO: Implement invoke method to calculate all moves for a piece in the west direction
  @Override
  public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
      ArrayList<String> moves = new ArrayList<String>();
      // int count = 0;
      // if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
      //     for (int i = getPieceColumn() - 1; i >= 0 && count < numMoves; i--) {
      //         if ((board.getCell(getPieceRow(), i).getPieceOnSquare()
      //                 == null || IsEnemy.invoke(board, getPieceRow(), i,getColorOfPiece().getColor()))) {
      //             moves.add(getPieceRow() + "," + i);
      //             count++;
      //             if (IsEnemy.invoke(board, getPieceRow(), i,getColorOfPiece().getColor())) {
      //                 break;
      //             }
      //         } else {
      //             break;
      //         }
      //     }
      // }
      return moves;
  }
}
