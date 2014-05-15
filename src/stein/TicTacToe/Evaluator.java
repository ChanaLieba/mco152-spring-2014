package stein.TicTacToe;


import java.util.ArrayList;

public class Evaluator {

	TicTacToeBoard board;
	Symbol winner;
	ArrayList<Location> loc;

	public Evaluator(TicTacToeBoard board) {
		this.board = board;
	}

	public void Evaluate() {
		Location loc1;
		Location loc2;
		Location loc3;
		loc = new ArrayList<Location>();
		do {
			for (int i = 0; i < 3; i++) {
				int j = 0;
				loc1 = new Location(j, i);
				loc2 = new Location(j + 1, i);
				loc3 = new Location(j + 2, i);
				if (board.getSquare(loc1) == board.getSquare(loc2)
						&& board.getSquare(loc2) == board.getSquare(loc3)
						&& board.getSquare(loc1) != null) {
					loc.add(loc1);
					loc.add(loc2);
					loc.add(loc3);
					winner = board.getSquare(loc1);
					return;
				}
				loc1 = new Location(i,j);
				loc2 = new Location(i, j+1);
				loc3 = new Location(i, j+2);
				if (board.getSquare(loc1) == board.getSquare(loc2)
						&& board.getSquare(loc2) == board.getSquare(loc3)
								&& board.getSquare(loc1) != null) {
					loc.add(loc1);
					loc.add(loc2);
					loc.add(loc3);
					winner = board.getSquare(loc1);
					return;

				}
			}
			loc1 = new Location(0, 0);
			loc2 = new Location(1, 1);
			loc3 = new Location(2, 2);
			if (board.getSquare(loc1) == board.getSquare(loc2)
					&& board.getSquare(loc2) == board.getSquare(loc3)
					&& board.getSquare(loc1) != null) {
				loc.add(loc1);
				loc.add(loc2);
				loc.add(loc3);
				winner = board.getSquare(loc1);
				return;
			}
			loc1 = new Location(0, 2);
			loc2 = new Location(1, 1);
			loc3 = new Location(2, 0);
			if (board.getSquare(loc1) == board.getSquare(loc2)
					&& board.getSquare(loc2) == board.getSquare(loc3)
					&& board.getSquare(loc1) != null) {
				loc.add(loc1);
				loc.add(loc2);
				loc.add(loc3);
				winner = board.getSquare(loc1);
				return;
			}
		} while (false);
	}

	public Symbol getWinner() {
		return winner;
	}

	public ArrayList<Location> getWinningSquares() {
		return loc;
	}
}
