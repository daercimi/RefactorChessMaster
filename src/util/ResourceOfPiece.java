package util;

public class ResourceOfPiece implements IResourceOfPiece {
    int color;

    public ResourceOfPiece(int pieceColor) {
        this.color = pieceColor;
    }

    // Implement the IResourceOfPiece interface method for getting the resource of a piece
    @Override
    public String resourceByType(String pieceType) {
        String PATH = "/ChessImages";
        if (color == ColorOfPiece.WHITE) {
            return PATH + "/White" + pieceType + ".gif";
        } else if (color == ColorOfPiece.BLACK) {
            return PATH + "/Black" + pieceType + ".gif";
        } else {
            return PATH + "/default-Unassigned.gif";
        }
    }

}