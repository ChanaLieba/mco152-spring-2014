package stein.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {
	@Test
	public void testAlphabetlToMorseCode() {
		MorseCode morseCode = new MorseCode();
		String alphabet = "MY NAME IS CHANA LIEBA STEIN";
		String code = morseCode.toMorseCode(alphabet);
		String expected = "-- -.-- / -. .- -- . / .. ... / -.-. .... .- -. .- / .-.. .. . -... .- / ... - . .. -. ";
		Assert.assertEquals(expected, code);
	}
	@Test
	public void test2(){
		MorseCode morseCode = new MorseCode();
		String alphabet2 = "-- -.-- / -. .- -- . / .. ... / -.-. .... .- -. .- / .-.. .. . -... .- / ... - . .. -. ";
		String code2 = morseCode.toPlainText(alphabet2);
		String expected2 = "MY NAME IS CHANA LIEBA STEIN";
		Assert.assertEquals(expected2, code2);
	}
}