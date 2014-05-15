package stein.checkers;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int	WIDTH	= 8;
	public static final int	HEIGHT	= 8;
	private final Piece[][]	board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		 return (x<8 && x>-1 && y<8 && y>-1);
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return false;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++){
				board[i][j] = null;
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board.length; j++){
				board[i][j] = null;
			}
		}
		setPiece(1, 0, Piece.WHITE_MAN);
		setPiece(3,0,Piece.WHITE_MAN);
		setPiece(5,0,Piece.WHITE_MAN);
		setPiece(7,0,Piece.WHITE_MAN);
		setPiece(0,1,Piece.WHITE_MAN);
		setPiece(2,1,Piece.WHITE_MAN);
		setPiece(4,1,Piece.WHITE_MAN);
		setPiece(6,1,Piece.WHITE_MAN);
		setPiece(1,2,Piece.WHITE_MAN);
		setPiece(3,2,Piece.WHITE_MAN);
		setPiece(5,2,Piece.WHITE_MAN);
		setPiece(7,2,Piece.WHITE_MAN);
		setPiece(0,5,Piece.RED_MAN);
		setPiece(2,5,Piece.RED_MAN);
		setPiece(4,5,Piece.RED_MAN);
		setPiece(6,5,Piece.RED_MAN);
		setPiece(1,6,Piece.RED_MAN);
		setPiece(3,6,Piece.RED_MAN);
		setPiece(5,6,Piece.RED_MAN);
		setPiece(7,6,Piece.RED_MAN);
		setPiece(0,7,Piece.RED_MAN);
		setPiece(2,7,Piece.RED_MAN);
		setPiece(4,7,Piece.RED_MAN);
		setPiece(6,7,Piece.RED_MAN);
		
		
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				if(board[i][j] == null){
					b.append("-");
				} else {
					b.append(board[i][j].toString());
				}
				
			}
			b.append("\n");
		}
		return b.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		Piece temp = getPiece(move.getX1(),move.getY1());
		setPiece(move.getX1(),move.getY1(), null) ;
		if(temp == Piece.WHITE_MAN && move.getY2() == 7){
			setPiece(move.getX2(), move.getY2(), Piece.WHITE_KING);
		}
		else if(temp == Piece.RED_MAN && move.getY2() == 0){
			setPiece(move.getX2(), move.getY2(), Piece.RED_KING);
		} else{
			setPiece(move.getX2(), move.getY2(), temp);
		}
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		Piece temp = getPiece(jump.getX1(),jump.getY1());
		setPiece(jump.getX1(),jump.getY1(), null) ;
		setPiece(jump.getCaptureX(),jump.getCaptureY(),null);
		if(temp == Piece.WHITE_MAN && jump.getY2() == 7){
			setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_KING);
		}
		else if(temp == Piece.RED_MAN && jump.getY2() == 0){
			setPiece(jump.getX2(), jump.getY2(), Piece.RED_KING);
		} else{
			setPiece(jump.getX2(), jump.getY2(), temp);
		}
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List list = new ArrayList<Move>();
		Move move = new Move(x,y,x-1,y-1);
		if(isOnBoard(move.getX2(), move.getY2()) && getPiece(move.getX2(), move.getY2()) == null  
				&& getPiece(move.getX1(), move.getY1()) != Piece.WHITE_MAN){
			list.add(move);
		}
		Move move2 = new Move(x,y,x+1,y+1);
		if(isOnBoard(move2.getX2(), move2.getY2())&& getPiece(move2.getX2(), move2.getY2()) == null
				&& getPiece(move2.getX1(), move2.getY1()) != Piece.RED_MAN){
			list.add(move2);
		}
		Move move3 = new Move(x,y,x+1, y-1);
		if(isOnBoard(move3.getX2(), move3.getY2())&& getPiece(move3.getX2(), move3.getY2()) == null
				&& getPiece(move3.getX1(), move3.getY1()) != Piece.WHITE_MAN){
			list.add(move3);
		}
		Move move4 = new Move(x,y,x-1,y+1);
		if(isOnBoard(move4.getX2(), move4.getY2())&& getPiece(move4.getX2(), move4.getY2()) == null
				&& getPiece(move4.getX1(), move4.getY1()) != Piece.RED_MAN){
			list.add(move4);
		}
		return list;
		
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List list = new ArrayList<Jump>();
		Jump jump = new Jump(x,y,x-1,y-1,x-2,y-2);
		Jump jump2 = new Jump(x,y,x+1, y-1, x+2, y-2);
		Jump jump3 = new Jump(x,y,x-1, y+1, x-2, y+2);
		Jump jump4 = new Jump(x,y,x+1, y+1, x+2, y+2);
		if(isOnBoard(jump.getX2(), jump.getY2()) && getPiece(jump.getCaptureX(), jump.getCaptureY()) != null
				&& getPiece(jump.getX1(),jump.getY1()) != Piece.WHITE_MAN){
			list.add(jump);
		}
		if(isOnBoard(jump2.getX2(), jump2.getY2()) && getPiece(jump2.getCaptureX(), jump2.getCaptureY()) != null
				&& getPiece(jump2.getX1(),jump2.getY1()) != Piece.WHITE_MAN){
			list.add(jump2);
		}
		if(isOnBoard(jump3.getX2(), jump3.getY2()) && getPiece(jump3.getCaptureX(), jump3.getCaptureY()) != null
				&& getPiece(jump3.getX1(),jump3.getY1()) != Piece.RED_MAN){
			list.add(jump3);
		}
		if(isOnBoard(jump4.getX2(), jump4.getY2()) && getPiece(jump4.getCaptureX(), jump4.getCaptureY()) != null
				&& getPiece(jump4.getX1(),jump3.getY1()) != Piece.RED_MAN){
			list.add(jump4);
		}
		return list;
	}

}
