package stein.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticsOfOWLBackend {

	File file;
	Scanner fileScanner;
	ArrayList<String> dictionary;
	Character[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };

	public StatisticsOfOWLBackend() throws FileNotFoundException {
		file = new File("./OWL.txt");
		fileScanner = new Scanner(file);
		dictionary = new ArrayList<String>();
		while (fileScanner.hasNextLine()) {
			dictionary.add(fileScanner.next());
			fileScanner.nextLine();
		}
	}

	public float[] getStatistics() {
		float[] integerArray = new float[26];
		boolean[] checkArray = new boolean[26];
		for (int n = 0; n < integerArray.length; n++) {
			integerArray[n] = (float) 0.0;
		}
		for (int k = 0; k < checkArray.length; k++) {
			checkArray[k] = false;
		}
		for (int i = 0; i < dictionary.size(); i++) {
			for (int j = 0; j < dictionary.get(i).length(); j++) {
				for (int w = 0; w < alphabet.length; w++) {
					if (alphabet[w].equals(dictionary.get(i).toUpperCase()
							.charAt(j))
							&& checkArray[w] != true) {
						integerArray[w] += 1.0;
					}
				}
			}
			for (int l = 0; l < checkArray.length; l++) {
				checkArray[l] = false;
			}
		}
		int total = 0;
		for (int p = 0; p < integerArray.length; p++) {
			total += integerArray[p];
		}
		for (int h = 0; h < integerArray.length; h++) {
			integerArray[h] = integerArray[h] / total;
			integerArray[h] = integerArray[h] * 100;
		}
		return integerArray;
	}

	public Character[] getAlphabet() {
		return alphabet;
	}

}
