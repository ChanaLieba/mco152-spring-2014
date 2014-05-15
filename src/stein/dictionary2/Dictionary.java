package stein.dictionary2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	private final Map<String, String> map;
	Scanner fileScanner;

	public Dictionary() throws FileNotFoundException {
		map = new HashMap<String, String>();
		fileScanner = new Scanner(new File("./OWL.txt"));
		while (fileScanner.hasNextLine()) {
			map.put(fileScanner.next(), fileScanner.nextLine());
		}
	}

	public boolean exists(String word) {
		return map.containsKey(word.toUpperCase());
	}

	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}

	public int size() {
		return map.size();
	}
	public String getDefinition(String word){
		return map.get(word);
	}

}
