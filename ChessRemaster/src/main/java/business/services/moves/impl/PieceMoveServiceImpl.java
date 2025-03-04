package business.services.moves.impl;

import business.game.ChessGameEngine;
import business.pieces.ChessGamePiece;
import business.services.moves.IPieceMoveService;
import gui.ChessGraveyard;
import gui.ChessPanel;
import gui.ChessGameBoard;
import utils.IsEnemy;
import utils.IsOnScreen;

import java.awt.*;

public class PieceMoveServiceImpl implements IPieceMoveService {

    /**
     * Update this piece's position.
     *
     * @param board the game board to move on
     * @param row   the row to move to
     * @param col   the column to move to
     * @return boolean true if the move was successful, false otherwise
     */
    @Override
    public boolean move(ChessGameBoard board, ChessGamePiece piece, int row, int col) {
        if (canMove(board,piece, row, col)) {
            String moveLog = this.toString() + " -> ";
            board.clearCell(piece.getRow(), piece.getColumn());
            if (IsEnemy.invoke(board, row, col,piece.getColorOfPiece().getColor())) {
                ChessGraveyard graveyard;
                ChessGameEngine gameEngine =
                        ((ChessPanel) board.getParent()).getGameEngine();
                if (gameEngine.getCurrentPlayer() == 1) {
                    graveyard =
                            ((ChessPanel) board.getParent()).getGraveyard(2);
                } else {
                    graveyard =
                            ((ChessPanel) board.getParent()).getGraveyard(1);
                }
                graveyard.addPiece(
                        board.getCell(row, col).getPieceOnSquare());
            }
            piece.setPieceLocation(row, col);
            moveLog += " (" + row + ", " + col + ")";
            ((ChessPanel) board.getParent()).getGameLog().addToLog(moveLog);
            board.getCell(row, col).setPieceOnSquare(piece);
            if (!piece.isSkipMoveGeneration()) {
                piece.calculatePossibleMoves(board);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determines if this piece can move to the specified row and column. Also
     * checks if the current player's king would be put in check by this move.
     *
     * @param board the board to move on
     * @param row   the row to move to
     * @param col   the column to move to
     * @return boolean true if this piece can make the move, false if it cannot
     */
    @Override
    public boolean canMove(ChessGameBoard board,ChessGamePiece piece, int row, int col) {
        piece.calculatePossibleMoves(board);
        if (piece.getPossibleMoves().indexOf(row + "," + col) > -1) {
            return testMoveForKingSafety(board,piece, row, col);
        }
        return false;
    }

    /**
     * Checks if the move that is about to be made would cause the current
     * player's King to be put in check (which is an illegal move).
     *
     * @param board the game board to check on
     * @param piece
     * @param row   the row to move to
     * @param col   the column to move to
     * @return boolean true if the move is safe, false if it is not
     */

    @Override
    public boolean testMoveForKingSafety(ChessGameBoard board, ChessGamePiece piece, int row, int col) {
        piece.calculatePossibleMoves(board);
        ChessGamePiece oldPieceOnOtherSquare =
                board.getCell(row, col).getPieceOnSquare();
        ChessGameEngine engine =
                ((ChessPanel) board.getParent()).getGameEngine();
        int oldRow = piece.getRow();
        int oldColumn = piece.getColumn();
        board.clearCell(piece.getRow(), piece.getColumn()); // move us off
        piece.setPieceLocation(row, col); // move us to the new location
        board.getCell(row, col).setPieceOnSquare(piece);
        boolean retVal = !engine.isKingInCheck(true); // is the current
        // king still in check?
        piece.setPieceLocation(oldRow, oldColumn); // move us back
        board.getCell(oldRow, oldColumn).setPieceOnSquare(piece);
        board.clearCell(row, col); // ^ move the other piece back
        // to where it was
        board.getCell(row, col).setPieceOnSquare(oldPieceOnOtherSquare);
        return retVal;
    }

    /**
     * Shows the legal move locations for this GamePiece.
     *
     * @param board The board to show the move locations on
     * @param piece
     */
    @Override
    public void showLegalMoves(ChessGameBoard board, ChessGamePiece piece) {
        piece.calculatePossibleMoves(board);
        if (IsOnScreen.invoke(piece.getRow(), piece.getColumn())) {
            for (String locStr : piece.getPossibleMoves()) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (canMove(board,piece, row, col)){ // only show legal moves
                    if (IsEnemy.invoke(board, row, col,piece.getColorOfPiece().getColor())) {
                        board.getCell(row, col).setBackground(
                                Color.YELLOW);
                    } else {
                        board.getCell(row, col).setBackground(Color.PINK);
                    }
                }
            }
        }
    }


    /**
     * Determines if this piece has legal moves to make.
     *
     * @param board the game board to check
     * @param piece
     * @return true if there are legal moves, false if there are not
     */
    @Override
    public boolean hasLegalMoves(ChessGameBoard board, ChessGamePiece piece) {
        piece.calculatePossibleMoves(board);
        if (IsOnScreen.invoke(piece.getRow(),piece.getColumn())) {
            for (String locStr : piece.getPossibleMoves()) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (canMove(board,piece, row, col)){ // only show legal moves
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}