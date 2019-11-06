package datastructures.array;

import java.util.Arrays;

public class PositiveNegativeArrangement {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { -8, -3, 4, 6, 1, -10, 2 , -1};
		Integer pivot = findPivot(array);
		System.out.println(pivot);
		Arrays.asList(array).forEach(System.out::print);

	}

	private static Integer findPivot(Integer[] array) {
		Integer pivot = 0;
		Integer low = 0;
		Integer high = array.length - 1;
		Integer index = 0;
		while (low < high) {
			while (low< high && array[low] < pivot) {
				low++;
			}
			while (low < high && array[high] > pivot) {
				high--;
			}
			if (low < high) {
				index = low;
				Integer temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}
		return index;
	}

}
