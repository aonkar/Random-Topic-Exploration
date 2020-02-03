package datastructures.array.matrix;

import java.util.HashSet;
import java.util.Set;

public class FindVolume {

	public static void main(String[] args) {
		String[][] matrix = new String[][] { { "*", "*", "*", "*", "*", "*" }, { "*", ".", ".", ".", ".", "*" },
				{ "*", ".", ".", ".", ".", "*" }, { "*", "*", "*", "*", "*", "*" } };
		Boolean[][] visitedMatrix = new Boolean[][] { { false, false, false, false, false, false },
				{ false, false, false, false, false, false }, { false, false, false, false, false, false },
				{ false, false, false, false, false, false } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j].equals(".") && !visitedMatrix[i][j]) {
					Set<String> currentNodes = new HashSet<>();
					System.out.println(findVolume(matrix, visitedMatrix, i, j, currentNodes));
				}
			}
		}

	}

	private static Integer findVolume(String[][] matrix, Boolean[][] visitedMatrix, Integer row, Integer column,
			Set<String> currentNodes) {
		if (row + 1 == matrix.length || row - 1 < 0 || column + 1 == matrix[0].length || column - 1 < 0
				|| (matrix[row][column + 1].equals(".") && visitedMatrix[row][column + 1]
						&& !currentNodes.contains(row + "" + (column + 1)))
				|| (matrix[row + 1][column].equals(".") && visitedMatrix[row + 1][column]
						&& !currentNodes.contains((row + 1) + "" + column))
				|| (matrix[row - 1][column].equals(".") && visitedMatrix[row - 1][column]
						&& !currentNodes.contains((row - 1) + "" + column))
				|| (matrix[row][column - 1].equals(".") && visitedMatrix[row][column - 1]
						&& !currentNodes.contains(row + "" + (column - 1)))) {
			visitedMatrix[row][column] = true;
			return -1;
		} else {
			Integer count = 1;
			visitedMatrix[row][column] = true;
			currentNodes.add((row) + "" + column);
			if (!visitedMatrix[row][column + 1] && matrix[row][column + 1].equals(".")) {
				Integer right = findVolume(matrix, visitedMatrix, row, column + 1, currentNodes);
				if (right == -1) {
					return -1;
				}
				count = count + right;
			}
			if (!visitedMatrix[row + 1][column] && matrix[row + 1][column].equals(".")) {
				Integer bottom = findVolume(matrix, visitedMatrix, row + 1, column, currentNodes);
				if (bottom == -1) {
					return -1;
				}
				count = count + bottom;
			}
			if (!visitedMatrix[row - 1][column] && matrix[row - 1][column].equals(".")) {
				Integer top = findVolume(matrix, visitedMatrix, row - 1, column, currentNodes);
				if (top == -1) {
					return -1;
				}
				count = count + top;
			}
			if (!visitedMatrix[row][column - 1] && matrix[row][column - 1].equals(".")) {
				Integer left = findVolume(matrix, visitedMatrix, row, column - 1, currentNodes);
				if (left == -1) {
					return -1;
				}
				count = count + left;
			}
			return count;
		}
	}

}
