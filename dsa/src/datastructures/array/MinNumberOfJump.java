package datastructures.array;

public class MinNumberOfJump {

	public static void main(String[] args) {
		int[] input = { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 };
		System.out.println(minNumberOfJumps(input));
	}

	public static int minNumberOfJumps(int[] array) {
		int jumpCount = 0;
		int index = 0;
		while (index < array.length) {
			int count = 1;
			int currSum = 0;
			int temp = index + 1;
			int iterationCount= index + array[index];
			if(index + array[index] >= array.length ) {
				return jumpCount;
			}
			for (int j = temp; j <= iterationCount + index; j++) {
				if(iterationCount >= array.length) {
					return ++jumpCount;
				}
				if (count + array[j] > currSum) {
					currSum += count + array[j];
					temp = j;
				}
				count++;
			}
			index = temp;
			jumpCount++;
		}
		return jumpCount;
	}
}
