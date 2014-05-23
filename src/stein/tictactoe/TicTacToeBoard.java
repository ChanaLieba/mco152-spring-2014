package stein.tictactoe;


public class TicTacToeBoard {

	Symbol[][] theBoard;

	public TicTacToeBoard() {
		theBoard = new Symbol[3][3];
	}

	public void reset() {
		for (int i = 0; i < theBoard.length; i++) {
			for (int j = 0; j < theBoard[i].length; j++) {
				theBoard[j][i] = null;
			}
		}

	}

	public boolean isFull() {
		for (int i = 0; i < theBoard.length; i++) {
			for (int j = 0; j < theBoard.length; j++) {
				if (theBoard[j][i] == null) {
					return false;
				}
			}
		}
		return true;

	}

	public void setSquare(Location location, Symbol symbol) {
		theBoard[location.getX()][location.getY()] = symbol;
	}

	public Symbol getSquare(Location location) {
		return theBoard[location.getX()][location.getY()];
	}

}
