package datastructures.array.matrix;

class MatrixRobotTraversal {
	static int count = 0;
	static boolean[][] visited = new boolean[7][3];

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
	}

	public static int uniquePaths(int m, int n) {
		getUniquePaths(m, n, 0, 0);
		return count;
	}

	public static void getUniquePaths(int m, int n, int row, int column) {
		if (row == m - 1 && column == n - 1 && ! visited[row][column]) {
			count++;
			return;
		}
		visited[row][column] = true;
		if (row + 1 < m) {
			getUniquePaths(m, n, row + 1, column);
		}
		if (column + 1 < n) {
			getUniquePaths(m, n, row, column + 1);
		}
	}
}
