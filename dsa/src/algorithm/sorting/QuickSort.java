package algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { -14, -12, 16,3, 8, -1 };
		quickSort(array, 0, array.length - 1);
		Arrays.asList(array).forEach(System.out::println);

	}

	private static void quickSort(Integer[] array, Integer low, Integer high) {

		if (low < high) {
			Integer pivot = array[(low + high) / 2];
			Integer index = partition(array, low, high, pivot);
			quickSort(array, index, high);
			quickSort(array, low, index - 1);
		}
	}

	private static Integer partition(Integer[] array, Integer low, Integer high, Integer pivot) {
		while(low <= high) {
			while(array[low] < pivot) {
				low++;
			}
			while(array[high] > pivot) {
				high--;
			}
			
			if(low<=high) {
				swap(array, low,high);
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
