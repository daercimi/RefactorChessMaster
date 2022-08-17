package gui;

import javax.swing.*;
import java.awt.*;

public class ChessPanel extends JPanel {

    private ChessMenuBar menuBar;
    private ChessGameLog gameLog;
    private ChessGraveyard playerOneGraveyard;
    private ChessGraveyard playerTwoGraveyard;


    public ChessGameLog getGameLog() {
        return gameLog;
    }

    public ChessGraveyard getGraveyard(int whichPlayer) {
        if (whichPlayer == 1) {
            return playerOneGraveyard;
        } else if (whichPlayer == 2) {
            return playerTwoGraveyard;
        } else {
            return null;
        }
    }
}
