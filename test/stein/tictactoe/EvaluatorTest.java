package stein.tictactoe;

import  org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void test1() {
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);
		Location loc1 = new Location(1,0);
		Location loc2 = new Location(1,1);
		Location loc3 = new Location(1,2);
		board.setSquare(loc1, Symbol.O);
		board.setSquare(loc2, Symbol.O);
		board.setSquare(loc3, Symbol.O);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.O);
	}
	@Test
	public void test2() {
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,0);
		Location lo1 = new Location(0,1);
		Location lo2 = new Location(0,2);
		bo.setSquare(lo, Symbol.O);
		bo.setSquare(lo1, Symbol.O);
		bo.setSquare(lo2, Symbol.O);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.O);
	}

}
