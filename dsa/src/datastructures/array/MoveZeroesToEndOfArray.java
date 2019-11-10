package datastructures.array;

import java.util.Arrays;

public class MoveZeroesToEndOfArray {

	public static void main(String[] args) {
		final Integer[] array = new Integer[] { 2, 4, 0, 1, 0, 5, 2, 1, 0, 7, 3, 6, 7, 0, 8, 3, 4 };
		Integer low = 0;
		Integer high = array.length -1;
		Integer pivot = 0;
		rearrange(array,low,high,pivot);
		Arrays.asList(array).forEach(System.out::print);

	}

	private static void rearrange(Integer[] array, Integer low, Integer high, Integer pivot) {
		while(low <= high) {
			while(low<high && array[low] != 0) {
				low++;
			}
			while(low<high && array[high] == 0) {
				high--;
			}
			
			if(low<=high) {
				swap(array,low,high);
				low++;
				high--;
			}
			
		}
		
	}
	
	private static void swap(Integer[] array, Integer low, Integer high) {
		Integer temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}

}
