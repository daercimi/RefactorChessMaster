package util;

public class ColorOfPiece {

    // Represent the color of the pieces as an integer
    public static final int BLACK = 0;

    public static final int WHITE = 1;

    // Represents a piece that has not been assigned a color
    public static final int UNASSIGNED = -1;

    private int color;

    public ColorOfPiece(int pieceColor) {
        this.color = pieceColor;
    }

    // Getter for color
    public int getColor() {
        return color;
    }
}