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
		int left = 0;
		int right = array.length - 1;
		int count = 0;
		int totalIterations = 0;
		while (left < right) {
			totalIterations++;
			if (array[left] + array[right] == sum) {
				boolean repeat = false;
				int leftCount = 1;
				int rightCount = 1;
				while (array[left] == array[left + 1] && left < right) {
					repeat = true;
					leftCount++;
					left++;
				}
				while (array[right] == array[right - 1] && right > left) {
					repeat = true;
					rightCount++;
					right--;
				}
				if (repeat) {
					count = count + leftCount * rightCount;
				} else {
					count++;
				}
				left++;
				right--;
			} else if (array[left] + array[right] > sum) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(totalIterations);
		return "Number of pairs possible are: " + count;
	}
}
