package datastructures.array;

public class FindPivotInRotatedArray {

	public static void main(String[] args) {
		final int[] array = new int[] { 2, 1 };
		System.out.println(findPivot(array, 0, array.length - 1));

	}

	private static int findPivot(final int[] array, final int low, final int high) {
		final int mid = (low + high) / 2;
		if (array.length == 1) {
			return 0;
		}
		if (mid == low && array[mid] < array[mid + 1]) {
			return -1;
		}
		if (array[mid] > array[mid + 1]) {
			return mid;
		} else if (array[mid] > array[low]) {
			return findPivot(array, mid, high);
		} else {
			return findPivot(array, low, mid);
		}
	}

}
