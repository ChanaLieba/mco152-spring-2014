package stein.stocks;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import junit.framework.Assert;

import org.junit.Test;

public class stockTest {

	@Test
	public void test1() throws NumberFormatException, IOException, ParseException {
		AmexData am = new AmexData();
		am.readInData();
		Assert.assertTrue(am.contains("AIP"));
	}
	@Test
	public void test2() throws NumberFormatException, IOException, ParseException {
		AmexData am = new AmexData();
		am.readInData();
		Assert.assertTrue(am.contains("BOI"));
	}
	@Test
	public void test3() throws NumberFormatException, IOException, ParseException {
		AmexData am = new AmexData();
		am.readInData();
		Assert.assertTrue(am.contains("CXM"));
	}
	@Test
	public void test4() throws NumberFormatException, IOException, ParseException {
		AmexData am = new AmexData();
		am.readInData();
		Assert.assertTrue(am.contains("DSI"));
	}


	


}
