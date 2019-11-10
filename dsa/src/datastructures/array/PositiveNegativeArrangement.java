package datastructures.array;

import java.util.Arrays;

public class PositiveNegativeArrangement {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { -8, 3, -10, 2, -1, -7, -8, 9, 6 };
		Integer pivot = findPivot(array, 0);
		if (pivot == array.length || pivot == 0) {
			System.out.println("Array is either complete positive or negative");
		} else {
			System.out.println(pivot);
			Arrays.asList(array).forEach(System.out::print);
			Integer index = pivot;
			for (int i = 1; i <= pivot && array[i]<0; i = i + 2) {
				if (index < array.length) {
					Integer temp = array[i];
					array[i] = array[index];
					array[index] = temp;
					index++;
				}
			}
			System.out.println("");
			Arrays.asList(array).forEach(System.out::print);
		}

	}

	private static Integer findPivot(Integer[] array, Integer pivot) {
		Integer low = 0;
		Integer high = array.length - 1;

		while (low <= high) {
			while (low < high && array[low] <= pivot) {
				low++;
			}
			while (low < high && array[high] > pivot) {
				high--;
			}
			if (low <= high) {
				swap(array, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(Integer[] array, Integer low, Integer high) {
		Integer temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}

}
