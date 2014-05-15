package stein.checkers;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n" + "--------\n" + "--------\n" + "r-r-r-r-\n"
				+ "-r-r-r-r\n" + "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Assert.assertTrue(board.isOnBoard(3, 4));
		Assert.assertTrue(board.isOnBoard(6, 7));
		Assert.assertFalse(board.isOnBoard(13, 14));
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Assert.assertTrue(board.getPiece(0, 3)==null);
		board.setPiece(0, 3, Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(0, 3) == Piece.WHITE_MAN);
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		for(int i = 0; i< 8; i++){
			for(int j = 0; j<8; j++){
				Assert.assertTrue(board.getPiece(i, j)==null);
			}
		}
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Assert.assertTrue(board.getPiece(1, 0) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(3, 0) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(7, 0) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(0, 1) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(2, 1) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(4, 1) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(6, 1) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(1, 2) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(3, 2) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(5, 2) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(7, 2) == Piece.WHITE_MAN);
		Assert.assertTrue(board.getPiece(0, 5) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(2, 5) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(4, 5) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(6, 5) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(1, 6) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(3, 6) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(5, 6) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(7, 6) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(0, 7) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(2, 7) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(4, 7) == Piece.RED_MAN);
		Assert.assertTrue(board.getPiece(6, 7) == Piece.RED_MAN);
		
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		Move move = new Move(1,2,0,3);
		board.execute(move);
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(0, 3));
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(7, 6, Piece.WHITE_MAN);
		Move move = new Move(7,6,6,7);
		board.execute(move);
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(6, 7));
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(6, 1, Piece.RED_MAN);
		Move move = new Move(6,1,7,0);
		board.execute(move);
		Assert.assertEquals(Piece.RED_KING, board.getPiece(7, 0));
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(6, 7, Piece.RED_MAN);
		board.setPiece(5, 6, Piece.WHITE_MAN);
		Jump jump = new Jump(6, 7, 5, 6, 4, 5);
		board.execute(jump);
		Assert.assertEquals(Piece.RED_MAN,board.getPiece(4, 5));
		
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(7, 2, Piece.RED_MAN);
		board.setPiece(6, 1, Piece.WHITE_MAN);
		Jump jump = new Jump(7, 2, 6, 1, 5, 0);
		board.execute(jump);
		Assert.assertEquals(Piece.RED_KING,board.getPiece(5, 0));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(5,6, Piece.RED_MAN);
		board.setPiece(4,5, Piece.WHITE_MAN);
		Jump jump = new Jump(4,5,5,6,6,7);
		board.execute(jump);
		Assert.assertEquals(Piece.WHITE_KING,board.getPiece(6,7));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.WHITE_MAN);
		board.setPiece(5, 0, Piece.WHITE_MAN);
		Assert.assertEquals(board.getMoves(4, 1).size() ,2 );
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.RED_MAN);
		Assert.assertEquals(board.getMoves(4, 1).size(), 2);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.RED_KING);
		Assert.assertEquals(board.getMoves(4, 1).size(), 4);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.WHITE_MAN);
		Assert.assertEquals(board.getMoves(4,1).size(), 2);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.WHITE_KING);
		Assert.assertEquals(board.getMoves(4,1).size(), 4);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.RED_KING);
		board.setPiece(5, 0, Piece.RED_KING);
		board.setPiece(3,0,Piece.WHITE_KING);
		board.setPiece(3, 2, Piece.RED_KING);
		board.setPiece(5, 2, Piece.RED_KING);
		Assert.assertEquals(board.getMoves(4, 1).size() ,0 );
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(0, 7, Piece.RED_KING);
		Assert.assertEquals(board.getMoves(0,7).size(), 1);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(7, 0, Piece.RED_KING);
		Assert.assertEquals(board.getMoves(7,0).size(), 1);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.RED_KING);
		Assert.assertEquals(board.getJumps(4,0).size(), 0);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 1, Piece.RED_KING);
		Assert.assertEquals(board.getJumps(4,0).size(), 0);
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 5, Piece.RED_KING);
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(3,6,Piece.WHITE_KING);
		board.setPiece(5, 4, Piece.RED_KING);
		board.setPiece(5, 6, Piece.RED_KING);
		Assert.assertEquals(board.getJumps(4, 5).size() ,4 );
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.clear();
		board.setPiece(4, 5, Piece.RED_MAN);
		board.setPiece(3, 4, Piece.RED_KING);
		board.setPiece(3,6,Piece.WHITE_KING);
		board.setPiece(5, 4, Piece.RED_KING);
		board.setPiece(5, 6, Piece.RED_KING);
		Assert.assertEquals(board.getJumps(4, 5).size() ,2 );
	}

}
