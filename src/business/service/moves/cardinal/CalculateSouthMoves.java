package business.service.moves.cardinal;

import java.util.ArrayList;

import gui.board.ChessGameBoard;
import util.ColorOfPiece;

public class CalculateSouthMoves extends CalculateCardinalMoves {
  public CalculateSouthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
    super(pieceRow, pieceColumn, colorOfPiece);
  }
  
  // TODO: Implement invoke method to calculate all moves for a piece in the south direction
  @Override
  public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
      ArrayList<String> moves = new ArrayList<String>();
      // int count = 0;
      // if (IsOnScreen.invoke(getPieceRow(), getPieceColumn())) {
      //     for (int i = getPieceRow() + 1; i < 8 && count < numMoves; i++) {
      //         if ((board.getCell(i, getPieceColumn()).getPieceOnSquare()
      //                 == null || IsEnemy.invoke(board, i, getPieceColumn(),getColorOfPiece().getColor()))) {
      //             moves.add(i + "," + getPieceColumn());
      //             count++;
      //             if (IsEnemy.invoke(board, i, getPieceColumn(),getColorOfPiece().getColor())) {
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
