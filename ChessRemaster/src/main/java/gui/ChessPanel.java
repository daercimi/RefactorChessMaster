package gui;

import business.game.ChessGameEngine;

import javax.swing.*;
import java.awt.*;

/**
 * The main panel of the Chess game.
 */
public class ChessPanel extends JPanel {
    private final ChessMenuBar menuBar;
    private final ChessGameBoard gameBoard;
    private final ChessGameLog gameLog;
    private final ChessGraveyard playerOneGraveyard;
    private final ChessGraveyard playerTwoGraveyard;
    private final ChessGameEngine gameEngine;

    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel() {
        this.setLayout(new BorderLayout());
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        gameLog = new ChessGameLog();
        playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
        playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
        this.add(menuBar, BorderLayout.NORTH);
        this.add(gameBoard, BorderLayout.CENTER);
        this.add(gameLog, BorderLayout.SOUTH);
        this.add(playerOneGraveyard, BorderLayout.WEST);
        this.add(playerTwoGraveyard, BorderLayout.EAST);
        this.setPreferredSize(new Dimension(800, 600));
        gameEngine = new ChessGameEngine(gameBoard); // start the game
    }

    /**
     * Gets the logger object for use in other classes.
     *
     * @return ChessGameLog the ChessGameLog object
     */
    public ChessGameLog getGameLog() {
        return gameLog;
    }

    /**
     * Gets the board object for use in other classes.
     *
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Gets the game engine object for use in other classes
     *
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine() {
        return gameEngine;
    }

    /**
     * Gets the appropriate graveyard object for use in other classes.
     *
     * @param whichPlayer the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard(int whichPlayer) {
        return switch (whichPlayer) {
            case 1 -> playerOneGraveyard;
            case 2 -> playerTwoGraveyard;
            default -> null;
        };
    }
}