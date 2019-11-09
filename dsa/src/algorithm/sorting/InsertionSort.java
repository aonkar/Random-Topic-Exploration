package algorithm.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { 2, 4, 1, 5, 2, 1, 7, 3, 6, 7, 8, 3, 4 };
		insertionSort(array);
		Arrays.asList(array).forEach(System.out::print);

	}

	private static void insertionSort(Integer[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			Integer low = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[low]) {
					low = j;
				}
			}
			if (low != i) {
				Integer temp = array[low];
				array[low] = array[i];
				array[i] = temp;
			}
		}

	}

}
