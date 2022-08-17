package business.service.moves.impl;

import business.service.moves.IPieceMoveService;

public class PieceMoveServiceImpl implements IPieceMoveService {

    /**
     * Update this piece's position.
     *
     * @param row the row to move to
     * @param col the column to move to
     * @return boolean true if the move was successful, false otherwise
     */
    @Override
    public boolean move(int row, int col) {
        return true;
    }

    /**
     * Determines if this piece can move to the specified row and column. Also
     * checks if the current player's king would be put in check by this move.
     *
     * @param row the row to move to
     * @param col the column to move to
     * @return boolean true if this piece can make the move, false if it cannot
     */
    @Override
    public boolean canMove(int row, int col) {
        return true;
    }

    /**
     * Checks if the move that is about to be made would cause the current
     * player's King to be put in check (which is an illegal move).
     *
     * @param row the row to move to
     * @param col the column to move to
     * @return boolean true if the move is safe, false if it is not
     */

    @Override
    public boolean testMoveForKingSafety(int row, int col) {
        return true;
    }

    /**
     * Shows the legal move locations for this GamePiece.
     *
     */
    @Override
    public void showLegalMoves() {

    }

    /**
     * Determines if this piece has legal moves to make.
     *
     * @return true if there are legal moves, false if there are not
     */
    @Override
    public boolean hasLegalMoves() {
        return false;
    }
}