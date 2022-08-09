package gui.Board;

import business.service.moves.IPieceMoveService;
import business.service.moves.impl.PieceMoveServiceImpl;
import util.ColorOfPiece;
import business.pieces.*;
import gui.ChessPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
// -------------------------------------------------------------------------

/**
 * The panel that represents the Chess game board. Contains a few methods that
 * allow other classes to access the physical board.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessGameBoard extends JPanel {
    private BoardSquare[][] chessCells;
    private BoardListener listener;
    private IPieceMoveService pieceMoveService;



    /**
     * Returns the entire board.
     *
     * @return BoardSquare[][] the chess board
     */
    public BoardSquare[][] getCells() {
        return chessCells;
    }

    /**
     * Checks to make sure row and column are valid indices.
     *
     * @param row the row to check
     * @param col the column to check
     * @return boolean true if they are valid, false otherwise
     */
    private boolean validateCoordinates(int row, int col) {
        return chessCells.length > 0 && chessCells[0].length > 0 &&
                row < chessCells.length && col < chessCells[0].length
                && row >= 0 && col >= 0;
    }

    /**
     * Gets the BoardSquare at row 'row' and column 'col'.
     *
     * @param row the row to look at
     * @param col the column to look at
     * @return BoardSquare the square found, or null if it does not exist
     */
    public BoardSquare getCell(int row, int col) {
        if (validateCoordinates(row, col)) {
            return chessCells[row][col];
        }
        return null;
    }

    /**
     * Clears the cell at 'row', 'col'.
     *
     * @param row the row to look at
     * @param col the column to look at
     */
    public void clearCell(int row, int col) {
        if (validateCoordinates(row, col)) {
            chessCells[row][col].clearSquare();
        } else {
            throw new IllegalStateException("Row " + row + " and column" +
                    " " + col + " are invalid, or the board has not been" +
                    "initialized. This square cannot be cleared.");
        }
    }

    /**
     * Gets all the black pieces on the board
     *
     * @return ArrayList<GamePiece> the pieces
     */
    public ArrayList<ChessGamePiece> getAllBlackPieces() {
        ArrayList<ChessGamePiece> blackPieces = new ArrayList<ChessGamePiece>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessCells[i][j].getPieceOnSquare() != null
                        && chessCells[i][j].getPieceOnSquare().getColorOfPiece().getColor() ==
                        ColorOfPiece.BLACK) {
                    blackPieces.add(chessCells[i][j].getPieceOnSquare());
                }
            }
        }
        return blackPieces;
    }

    /**
     * Create a new ChessGameBoard object.
     */
    public ChessGameBoard() {
        this.setLayout(new GridLayout(8, 8, 1, 1));
        listener = new BoardListener();
        chessCells = new BoardSquare[8][8];
        initializeBoard();
        pieceMoveService = new PieceMoveServiceImpl();
    }

    /**
     * (Re)initializes this ChessGameBoard to its default layout with all 32
     * pieces added.
     */
    public void initializeBoard() {
        resetBoard(false);
        for (int i = 0; i < chessCells.length; i++) {
            for (int j = 0; j < chessCells[0].length; j++) {
                ChessGamePiece pieceToAdd;
                if (i == 1) // black pawns
                {
                    pieceToAdd = new Pawn(this, i, j, ColorOfPiece.BLACK);
                } else if (i == 6) // white pawns
                {
                    pieceToAdd = new Pawn(this, i, j, ColorOfPiece.WHITE);
                } else if (i == 0 || i == 7) // main rows
                {
                    int colNum =
                            i == 0 ? ColorOfPiece.BLACK : ColorOfPiece.WHITE;
                    if (j == 0 || j == 7) {
                        pieceToAdd = new Rook(this, i, j, colNum);
                    } else if (j == 1 || j == 6) {
                        pieceToAdd = new Knight(this, i, j, colNum);
                    } else if (j == 2 || j == 5) {

                        pieceToAdd = new Bishop(this, i, j, colNum);

                    } else if (j == 3) {
                        pieceToAdd = new King(this, i, j, colNum);
                    } else {
                        pieceToAdd = new Queen(this, i, j, colNum);
                    }
                } else {
                    pieceToAdd = null;
                }
                chessCells[i][j] = new BoardSquare(i, j, pieceToAdd);
                if ((i + j) % 2 == 0) {
                    chessCells[i][j].setBackground(Color.WHITE);
                } else {
                    chessCells[i][j].setBackground(Color.BLACK);
                }
                chessCells[i][j].addMouseListener(listener);
                this.add(chessCells[i][j]);
            }
        }
    }

}