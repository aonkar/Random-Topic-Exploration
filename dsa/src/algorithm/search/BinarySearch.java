package algorithm.search;

public class BinarySearch {

	public static void main(String[] args) {
		final int[] array = new int[] { 1, 2, 3, 4, 5 };
		int searchElement = 5;
		System.out.println(search(array, searchElement, 0, array.length - 1));

	}

	private static String search(final int[] array, int searchElement, final int low, final int high) {
		if (low > high) {
			return "Not Found";
		} else {
			int mid = (low + high) / 2;
			if (array[mid] == searchElement) {
				return "Found at : " + mid;
			} else if (array[mid] > searchElement) {
				return search(array, searchElement, low, mid - 1);
			} else {
				return search(array, searchElement, mid + 1, high);
			}
		}

	}

}
