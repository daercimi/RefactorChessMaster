package business.service.moves.cardinal;

import java.util.ArrayList;

import gui.board.ChessGameBoard;
import util.ColorOfPiece;

public class CalculateNorthMoves extends CalculateCardinalMoves {
  public CalculateNorthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
    super(pieceRow, pieceColumn, colorOfPiece);
  }

  // TODO: Implement invoke method to calculate all moves for a piece in the east direction
  @Override
  public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
      ArrayList<String> moves = new ArrayList<>();
      // int count = 0;
      // if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
      //     for (int i = getPieceRow() - 1; i >= 0 && count < numMoves; i--) {
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
