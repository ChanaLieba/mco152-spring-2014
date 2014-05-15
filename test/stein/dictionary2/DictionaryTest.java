package stein.dictionary2;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {
	@Test
	public void testDictionary() {
		
		try {
			Dictionary dic = new Dictionary();
			String word = "me";
			Assert.assertTrue(dic.exists(word));
			Assert.assertTrue(dic.exists("Oval"));
			Assert.assertFalse(dic.exists("Blablabla"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}