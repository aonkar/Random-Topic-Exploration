package datastructures.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class EvenOddRearrangement {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6};
		Stream.of(arrangeEvenOdd(array)).forEach(System.out::println);

	}

	private static Integer[] arrangeEvenOdd(Integer[] array) {
		Collections.sort(Arrays.asList(array));
		Integer[] newArray = new Integer[array.length];
		final int pivot;
		if (array.length % 2 == 0) {
			pivot = array.length / 2;
		} else {
			pivot = (array.length / 2) + 1;
		}
		int j = 1;
		for (int i = pivot; i < array.length; i++) {
			if (j >= array.length) {
				break;
			}
			newArray[j] = array[i];
			j = j + 2;
		}
		j = 0;
		for (int i = pivot - 1; i >= 0; i--) {
			newArray[j] = array[i];
			j = j + 2;
		}
		return newArray;
	}

}
