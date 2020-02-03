package datastructures.array;

public class SubArraySort {

	public static void main(String[] args) {
		int[] testInput = new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		int[] result = subarraySort(testInput);
		for (int number : result) {
			System.out.print(number);
		}

	}

	public static int[] subarraySort(int[] array) {
		int start = -1;
		int end = -1;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max > array[i]) {
				if (start == -1 || array[start] > array[i]) {
					for (int j = 0; j < i; j++) {
						if (array[j] > array[i]) {
							start = j;
							break;
						}
					}
				}
				end = i;
			} else {
				max = array[i];
			}
		}
		return new int[] { start, end };
	}
}
