package datastructures.array;

import java.util.Arrays;
import java.util.List;

public class RearrangeArray {

	public static void main(String[] args) {
		final List<Integer> array = Arrays.asList(1, -1, 4, 5, 0, 6, 3);
		rearrangeArray(array);
		array.forEach(System.out::println);

	}

	private static void rearrangeArray(List<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			boolean endNotReached = true;
			if (array.get(i) != i && array.get(i) != -1) {
				while (endNotReached) {
					int temp = array.get(array.get(i));
					array.set(array.get(i), array.get(i));
					if (temp == -1) {
						endNotReached = false;
					}
				}
			}
		}

	}

}
