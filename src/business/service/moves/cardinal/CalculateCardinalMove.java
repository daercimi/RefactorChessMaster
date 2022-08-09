package business.service.moves.cardinal;

public class CalculateCardinalMove {
  private int pieceRow;
    private int pieceColumn;
    private ColorOfPiece colorOfPiece;

    public CalculateCardinalMove(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    public int getPieceRow() {
        return pieceRow;
    }

    public void setPieceRow(int pieceRow) {
        this.pieceRow = pieceRow;
    }

    public int getPieceColumn() {
        return pieceColumn;
    }

    public void setPieceColumn(int pieceColumn) {
        this.pieceColumn = pieceColumn;
    }

    public ColorOfPiece getColorOfPiece() {
        return colorOfPiece;
    }

    public void setColorOfPiece(ColorOfPiece colorOfPiece) {
        this.colorOfPiece = colorOfPiece;
    }
}

class ColorOfPiece {

  /**
   * Represents a black piece as an int
   */
  public static final int BLACK = 0;
  /**
   * Represents a white piece as an int
   */
  public static final int WHITE = 1;
  /**
   * Represents a piece that has not been assigned a color
   */
  public static final int UNASSIGNED = -1;

  private int color;

  public ColorOfPiece(int pieceColor) {
      this.color = pieceColor;
  }

  public int getColor() {
      return color;
  }
}
