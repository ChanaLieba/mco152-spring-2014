package stein.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Integer> list = new HashMap<Integer, Integer>();
		System.out.println("Enter 10 numbers");
		for (int i = 0; i < 10; i++) {
			int num = scanner.nextInt();
			if (!list.containsKey(num)) {
				list.put(num, 1);
			} else {
				list.put(num, (list.get(num) + 1));
			}
		}

		System.out.println(list);
	}

}
