package datastructures.array;

import java.util.Arrays;

public class KthSmallestElement {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { 4, 3, 2, 1, 5, 8, 7, 6, -1, 0, 9, 5 };
		final Integer k = 1;
		final Integer kthSmallestNumber = findKthSmallestElement(array, 0, array.length - 1, k);
		System.out.println(kthSmallestNumber);
		Arrays.asList(array).forEach(System.out::print);

	}

	private static Integer findKthSmallestElement(Integer[] array, Integer low, Integer high, Integer k) {

		if (low < high && k <= array.length) {
			Integer pivot = array[(low + high) / 2];
			Integer index = partition(array, low, high, pivot);
			if (index == k - 1) {
				return index;
			} else if (index > k - 1) {
				if (index == 1 && k - 1 == 0) {
					return 0;
				}
				return findKthSmallestElement(array, low, index - 1, k);
			} else {
				return findKthSmallestElement(array, index, high, k);
			}
		} else {
			return null;
		}

	}

	private static Integer partition(Integer[] array, Integer low, Integer high, Integer pivot) {
		while (low <= high) {
			while (array[low] < pivot) {
				low++;
			}
			while (array[high] > pivot) {
				high--;
			}
			if (low <= high) {
				Integer temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}

}
