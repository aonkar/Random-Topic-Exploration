package algorithm.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		final Integer[] array = new Integer[] { 2, 4, 1, 5, 2, 1, 7, 3, 6, 7, 8, 3, 4 };
		bubbleSort(array);
		Arrays.asList(array).forEach(System.out::print);

	}

	private static void bubbleSort(Integer[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - (i + 1); j++) {
				if (array[j] > array[j + 1]) {
					Integer temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

}
