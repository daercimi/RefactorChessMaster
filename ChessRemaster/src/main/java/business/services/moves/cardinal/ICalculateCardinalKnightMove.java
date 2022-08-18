package business.services.moves.cardinal;

import gui.ChessGameBoard;

import java.util.ArrayList;

public interface ICalculateCardinalKnightMove {

    ArrayList<String> invoke(ChessGameBoard board);

}
