package datastructures.array.matrix;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 2, 3, 4, 5 },
									  { 6, 7, 8, 9, 10 },
									  { 11, 12, 13, 14, 15 },
									  { 16, 17, 18, 19, 20 },
									  { 21, 22, 23, 24, 25}
									};
		printSprial(input);
	}

	private static void printSprial(int[][] input) {
		int firstRow = 0;
		int firstColumn = 0;
		int lastRow = input.length - 1;
		int lastColumn = input[0].length - 1;

		while (firstRow <= lastRow && firstColumn <= lastColumn) {
			for (int i = firstColumn; i <= lastColumn; i++) {
				System.out.println(input[firstRow][i]);
			}
			firstRow++;
			for (int i = firstRow; i <= lastRow; i++) {
				System.out.println(input[i][lastColumn]);
			}
			lastColumn--;
			if (firstRow <= lastRow) {
				for (int i = lastColumn; i >= firstColumn; i--) {
					System.out.println(input[lastRow][i]);
				}
				lastRow--;
			}
			if (firstColumn <= lastColumn) {
				for (int i = lastRow; i >= firstRow; i--) {
					System.out.println(input[i][firstColumn]);
				}
				firstColumn++;
			}
		}
	}
}
