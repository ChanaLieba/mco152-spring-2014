package stein.morseCode;

public class MorseCode {
	public String toMorseCode(String word) {
		StringBuilder output = new StringBuilder();
		output.append("");
		for (int i = 0; i < word.length(); i++) {
			StringBuilder a = new StringBuilder();
			a.append(word.substring(i, i + 1).toUpperCase());
			if (a.toString().equals("A")) {
				output.append(".- ");
			} else if (a.toString().equals("B")) {
				output.append("-... ");
			} else if (a.toString().equals("C")) {
				output.append("-.-. ");
			} else if (a.toString().equals("D")) {
				output.append("-.. ");
			} else if (a.toString().equals("E")) {
				output.append(". ");
			} else if (a.toString().equals("F")) {
				output.append("..-. ");
			} else if (a.toString().equals("G")) {
				output.append("--. ");
			} else if (a.toString().equals("H")) {
				output.append(".... ");
			} else if (a.toString().equals("I")) {
				output.append(".. ");
			} else if (a.toString().equals("J")) {
				output.append(".--- ");
			} else if (a.toString().equals("K")) {
				output.append("-.- ");
			} else if (a.toString().equals("L")) {
				output.append(".-.. ");
			} else if (a.toString().equals("M")) {
				output.append("-- ");
			} else if (a.toString().equals("N")) {
				output.append("-. ");
			} else if (a.toString().equals("O")) {
				output.append("--- ");
			} else if (a.toString().equals("P")) {
				output.append(".--. ");
			} else if (a.toString().equals("Q")) {
				output.append("--.- ");
			} else if (a.toString().equals("R")) {
				output.append(".-. ");
			} else if (a.toString().equals("S")) {
				output.append("... ");
			} else if (a.toString().equals("T")) {
				output.append("- ");
			} else if (a.toString().equals("U")) {
				output.append("..- ");
			} else if (a.toString().equals("V")) {
				output.append("..- ");
			} else if (a.toString().equals("W")) {
				output.append("..- ");
			} else if (a.toString().equals("X")) {
				output.append("-..- ");
			} else if (a.toString().equals("Y")) {
				output.append("-.-- ");
			} else if (a.toString().equals("Z")) {
				output.append("--.. ");
			} else if (a.toString().equals("0")) {
				output.append("----- ");
			} else if (a.toString().equals("1")) {
				output.append(".---- ");
			} else if (a.toString().equals("2")) {
				output.append("..--- ");
			} else if (a.toString().equals("3")) {
				output.append("...-- ");
			} else if (a.toString().equals("4")) {
				output.append("....- ");
			} else if (a.toString().equals("5")) {
				output.append("..... ");
			} else if (a.toString().equals("6")) {
				output.append("-.... ");
			} else if (a.toString().equals("7")) {
				output.append("--... ");
			} else if (a.toString().equals("8")) {
				output.append("---.. ");
			} else if (a.toString().equals("9")) {
				output.append("----. ");
			} else if (a.toString().equals(".")) {
				output.append(".-.-.- ");
			} else if (a.toString().equals(",")) {
				output.append("--..-- ");
			} else if (a.toString().equals("?")) {
				output.append(".--.. ");
			} else if (a.toString().equals("=")) {
				output.append("-...- ");
			} else if (a.toString().equals(" ")) {
				output.append("/ ");
			}
		}
		return output.toString();
	}

	public String toPlainText(String word) {
		StringBuilder output = new StringBuilder();
		String[] a = word.split("\\s");
		for (int i = 0; i < a.length; i++) {		
				String b = a[i];
			if (b.equals(".-")) {
				output.append ("A");
			} else if (b.equals("-...")) {
				output .append ("B");
			} else if (b.equals("-.-.")) {
				output .append ("C");
			} else if (b.equals("-..")) {
				output .append ("D");
			} else if (b.equals(".") ) {
				output .append ("E");
			} else if (b.equals("..-.")) {
				output .append ("F");
			} else if (b.equals("--.")) {
				output .append ("G");
			} else if (b.equals("....")) {
				output .append ("H");
			} else if (b.equals("..")) {
				output .append ("I");
			} else if (b.equals(".---")) {
				output .append ("J");
			} else if (b.equals("-.-")) {
				output .append ("K");
			} else if (b.equals(".-..")) {
				output .append ("L");
			} else if (b.equals("--")) {
				output.append("M");
			} else if (b.equals("-.") ) {
				output .append("N") ;
			} else if (b.equals("---")) {
				output .append( "O");
			} else if (b.equals(".--.")) {
				output .append("P") ;
			} else if (b.equals("--.-")) {
				output .append ("Q");
			} else if (b.equals(".-.")) {
				output .append ("R");
			} else if (b.equals("...")) {
				output .append ("S");
			} else if (b.equals("-")) {
				output .append ("T");
			}else if (b.equals("..-")) {
				output .append ("U");
			} else if (b.equals("..-")) {
				output .append ("V");
			} else if (b.equals("..-")) {
				output .append ("W");
			} else if (b.equals("-..-")) {
				output .append ("X");
			} else if (b.equals("-.--") ) {
				output .append ("Y");
			} else if (b.equals("--..")) {
				output .append ("Z");
			} else if (b.equals("-----") ) {
				output .append ("0");
			} else if (b.equals(".----")) {
				output .append ("1");
			} else if (b.equals("..---") ) {
				output .append ("2");
			} else if (b.equals("...--")) {
				output .append ("3");
			} else if (b.equals("....-")) {
				output .append ("4");
			} else if (b.equals(".....")) {
				output .append ("5");
			} else if (b.equals("-....")) {
				output .append ("6");
			} else if (b.equals("--...") ) {
				output .append ("7");
			} else if (b.equals("---..") ) {
				output .append ("8");
			} else if (b.equals("----.")) {
				output .append ("9");
			} else if (b.equals(".-.-.-")) {
				output .append (".");
			} else if (b.equals("--..--") ) {
				output .append (",");
			} else if (b.equals(".--..") ) {
				output .append ("?");
			} else if (b.equals("-...-") ) {
				output .append ("=");
			} else if (b.equals("/") ) {
				output .append(" ") ;
			}
			output .append("");
		}
		return output.toString();
	}
}

