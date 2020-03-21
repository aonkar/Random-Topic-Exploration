package datastructures.array.matrix;

import java.util.Arrays;

public class MinimumCoinChangeProblem {

	public static void main(String[] args) {
		int[] input = { 2, 1 };
		System.out.println(minNumberOfCoinsForChange(3, input));
	}

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		Arrays.sort(denoms);
		int[][] costMatrix = new int[denoms.length][n + 1];
		for (int i = 0; i < denoms.length; i++) {
			costMatrix[i][0] = 0;
		}
		for (int i = 1; i <= n; i++) {
			if (i % denoms[0] == 0) {
				costMatrix[0][i] = i / denoms[0];
			} else {
				costMatrix[0][i] = 0;
			}
		}

		for (int i = 1; i < denoms.length; i++) {
			for (int j = 1; j <= n; j++) {
				if (denoms[i] > j) {
					costMatrix[i][j] = costMatrix[i - 1][j];
				} else {
					if (j % denoms[i] == 0) {
						if (costMatrix[i - 1][j] != 0) {
							costMatrix[i][j] = (costMatrix[i - 1][j]) < (j / denoms[i]) ? (costMatrix[i - 1][j])
									: (j / denoms[i]);
						} else {
							costMatrix[i][j] = j / denoms[i];
						}
					} else {
						int reminder = j % denoms[i];
						if (costMatrix[i - 1][j - reminder] == 0) {
							costMatrix[i][j] = 0;
						} else {
							costMatrix[i][j] = j / denoms[i] + costMatrix[i - 1][j - (j / denoms[i]) * denoms[i]];
						}
					}
				}
			}
		}
		return costMatrix[denoms.length - 1][n];
	}
}