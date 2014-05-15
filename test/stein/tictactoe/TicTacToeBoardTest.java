package stein.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void test() {
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
	@Test
	public void test2(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(2,0);
		Location lo1 = new Location(2,1);
		Location lo2 = new Location(2,2);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}	@Test
	public void test3(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(1,0);
		Location lo1 = new Location(1,1);
		Location lo2 = new Location(1,2);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}	@Test
	public void test4(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,1);
		Location lo1 = new Location(1,1);
		Location lo2 = new Location(2,1);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}	@Test
	public void test5(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,0);
		Location lo1 = new Location(1,0);
		Location lo2 = new Location(2,0);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}	@Test
	public void test6(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,2);
		Location lo1 = new Location(1,2);
		Location lo2 = new Location(2,2);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}	@Test
	public void test7(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,0);
		Location lo1 = new Location(1,1);
		Location lo2 = new Location(2,2);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}	@Test
	public void test8(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,2);
		Location lo1 = new Location(1,1);
		Location lo2 = new Location(2,0);
		bo.setSquare(lo, Symbol.X);
		bo.setSquare(lo1, Symbol.X);
		bo.setSquare(lo2, Symbol.X);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), Symbol.X);
		
	}
	@Test
	public void test9(){
		TicTacToeBoard bo = new TicTacToeBoard();
		Evaluator eval = new Evaluator(bo);
		Location lo = new Location(0,2);
		Location lo1 = new Location(1,1);
		Location lo2 = new Location(2,0);
		bo.setSquare(lo, null);
		bo.setSquare(lo1, null);
		bo.setSquare(lo2, null);
		eval.Evaluate();
		Assert.assertEquals(eval.getWinner(), null);
	}
	

}
