package datastructures.array.matrix;

public class CoinChangeCombinationsProblem {

	public static void main(String[] args) {
		int[] input = { 2, 3 ,7 };
		System.out.println(numberOfWaysToMakeChange(12, input));
	}

	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		int[][] costMatrix = new int[denoms.length][n + 1];
		for (int i = 0; i < denoms.length; i++) {
			costMatrix[i][0] = 1;
		}
		for (int i = 0; i <= n; i++) {
			if (i % denoms[0] == 0) {
				costMatrix[0][i] = 1;
			} else {
				costMatrix[0][i] = 0;
			}
		}
		for (int i = 1; i < denoms.length; i++) {
			for (int j = 1; j <= n; j++) {
				if (denoms[i] > j) {
					costMatrix[i][j] = costMatrix[i - 1][j];
				} else {
					costMatrix[i][j] = costMatrix[i - 1][j] + costMatrix[i][j - denoms[i]];
				}
			}
		}
		return costMatrix[denoms.length - 1][n];
	}

}
