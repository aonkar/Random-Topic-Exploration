package datastructures.array;

import java.util.stream.Stream;

public class ReverseArray {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6 };
		reverseArray(array);
		Stream.of(array).forEach(System.out::print);
	}

	private static void reverseArray(final Integer[] array) {
		int last = array.length - 1;
		for (int i = 0; i < array.length/2; i++) {
			Integer temp = array[i];
			array[i] = array[last];
			array[last] = temp;
			last--;
		}
	}

}
