package algorithm;

public class KnapSack {

	public static void main(String[] args) {
		Integer targetWeight = 50;
		Integer[] value = { 60, 100, 120 };
		Integer[] weight = { 10, 20, 30 };
		Integer[][] matrix = new Integer[value.length + 1][targetWeight + 1];
		System.out.println(findMaxValue(matrix, value, weight, targetWeight));
	}

	private static Integer findMaxValue(Integer[][] matrix, Integer[] value, Integer[] weight, Integer targetWeight) {
		for (int i = 0; i <= value.length; i++) {
			for (int j = 0; j <= targetWeight; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (weight[i - 1] <= j) {
					matrix[i][j] = max(value[i - 1] + matrix[i - 1][j - weight[i - 1]], matrix[i - 1][j]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix[value.length][targetWeight];
	}

	private static Integer max(int num1, Integer num2) {

		return num1 > num2 ? num1 : num2;
	}
}
