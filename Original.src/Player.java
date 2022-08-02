import java.util.ArrayList;

public class Player {
  private int playerId;
  private King king;
  private ChessGamePiece currentPiece;

  public Player(int playerId) {
    this.playerId = playerId;
  }

  public int getPlayerId() {
    return this.playerId;
  }
  
  // TODO: Refactor this method to remove the conditionals
  // Determines if the requested player has legal moves.
  public boolean playerHasLegalMoves( ChessGameBoard board ){
    ArrayList<ChessGamePiece> pieces;
    if ( this.playerId == 1 ){
        pieces = board.getAllWhitePieces();
    }
    else if ( this.playerId == 2 ){
        pieces = board.getAllBlackPieces();
    }
    else
    {
        return false;
    }
    for ( ChessGamePiece currPiece : pieces ){
        if ( currPiece.hasLegalMoves( board ) ){
            return true;
        }
    }
    return false;
  }

  // Determines if the requested King is in check.
    public boolean isKingInCheck(ChessGameBoard board, boolean checkCurrent ){
          return king.isChecked( board );
    }

    public boolean selectedPieceIsValid(){
      if ( currentPiece == null ) // user tried to select an empty square
      {
          return false;
      }
      if ( this.playerId == 2 ) // black player
      {
          if ( currentPiece.getColorOfPiece() == ChessGamePiece.BLACK ){
              return true;
          }
          return false;
      }
      else
      // white player
      {
          if ( currentPiece.getColorOfPiece() == ChessGamePiece.WHITE ){
              return true;
          }
          return false;
      }
    }
}
