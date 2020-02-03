package datastructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer testCases = scanner.nextInt();
		List<Integer> numbers = new ArrayList<>(testCases);
		for (int i = 0; i < testCases; i++) {
			numbers.add(scanner.nextInt());
		}
		scanner.close();
		numbers.forEach(number -> {
			Integer values = 1;
			Integer count = 0;
			List<Integer> finalList = new ArrayList<>();
			while (!count.equals(number)) {
				List<Integer> temp = decToBinary(values);
				if (!temp.isEmpty()) {
					count++;
					finalList = temp;
				}
				values++;
			}
			for (int i = finalList.size() - 1; i >= 0; i--) {
				System.out.print(finalList.get(i));
			}
		});
	}

	static List<Integer> decToBinary(int n) {
		List<Integer> binary = new ArrayList<>();
		int count = 0;
		while (n > 0) {
			binary.add(n % 2);
			n = n / 2;
			if (n % 2 == 1 && binary.get(count) == 1) {
				return new ArrayList<>(0);
			}
		}
		return binary;

	}
}
