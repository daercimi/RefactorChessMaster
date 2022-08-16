package business.service.moves;


public interface IPieceMoveService {

    boolean move(int row, int col);

    boolean canMove(int row, int col);

    boolean testMoveForKingSafety(nt row, int col);

    void showLegalMoves();

    boolean hasLegalMoves();

}