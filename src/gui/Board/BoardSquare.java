package gui.Board;

import business.pieces.ChessGamePiece;

import javax.swing.*;

/**
 * Represents a cell on the chess board. Holds a game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class BoardSquare extends JPanel {
    private int row;
    private int col;
    private ChessGamePiece piece;
    private JLabel imageLabel;

    /**
     * Create a new BoardSquare object.
     *
     * @param row   the row
     * @param col   the column
     * @param piece the game piece
     */
    public BoardSquare(int row, int col, ChessGamePiece piece) {
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        updateImage();
    }

    /**
     * Updates the image for this BoardSquare.
     */
    private void updateImage() {
        if (imageLabel != null) {
            removeAll();
        }
        if (piece != null) {
            imageLabel = new JLabel();
            imageLabel.setIcon(piece.getImage());
            add(imageLabel);
        }
        revalidate(); // repaint wasn't working, gotta force the window manager
        // to redraw...
    }

}