package datastructures.array;

public class MacSubset {
	public static void main(String[] args) {
		System.out.println(maxSubsetSumNoAdjacent(new int[]{7,9,12,7,9,14}));
	}

	public static int maxSubsetSumNoAdjacent(int[] array) {
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0, j = 1; i < array.length; i = i + 2, j = j + 2) {
			oddSum += array[i];
			if (j < array.length)
				evenSum += array[j];
		}
		return oddSum > evenSum ? oddSum : evenSum;
	}
}
