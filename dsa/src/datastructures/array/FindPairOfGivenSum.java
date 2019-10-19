package datastructures.array;

public class FindPairOfGivenSum {

	public static void main(String[] args) {
		final int[] array = new int[] { -1, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6 };
		final int sum = 5;
		System.out.println(findPair(array, sum));
	}

	private static String findPair(int[] array, int sum) {
		if (array.length < 2 || array[0] > sum) {
			return "Not Available";
		}
		int i = 0, count = 0;
		int length = array.length;
		while (i < length) {
			for (int j = i + 1; j < length; j++) {
				if (array[i] + array[j] == sum) {
					count++;
				} else if (array[i] + array[j] > sum) {
					length = j;
				}
			}
			i++;

		}
		return "Number of pairs possible are: " + count;
	}
}
