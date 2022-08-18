package utils;

public class ResourceOfPiece implements IResourceOfPiece{

    int color;

    public ResourceOfPiece(int pieceColor){
        this.color = pieceColor;
    }

    @Override
    public String resourceByType(String pieceType) {
        String path = "/ChessImages";
        return switch (color) {
            case ColorOfPiece.WHITE -> path+"/White"+pieceType+".gif";
            case ColorOfPiece.BLACK -> path+"/Black"+pieceType+".gif";
            default -> path+"/default-Unassigned.gif";
        };
    }
    
}
