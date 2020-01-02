package datastructures.array.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatchTheFire {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int column = scan.nextInt();
		int[][] inputMatrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (scan.hasNextInt()) {
					inputMatrix[i][j] = scan.nextInt();
				}
			}
		}
		scan.close();
		final int ROW_SIZE = inputMatrix.length;
		final int COLUMN_SIZE = inputMatrix[0].length;
		int timeFrame = 0;
		final List<Pair> finalSet = new ArrayList<>();
		findInitalSetValues(inputMatrix, finalSet, ROW_SIZE, COLUMN_SIZE);
		if (finalSet.isEmpty()) {
			System.out.println(-1);
			return;
		}
		int startIndex = 0;
		int endIndex = finalSet.size();
		while (finalSet.size() != ROW_SIZE * COLUMN_SIZE) {
			timeFrame++;
			setNeighboursOnFire(inputMatrix, finalSet, startIndex, endIndex, ROW_SIZE, COLUMN_SIZE);
			startIndex = endIndex;
			endIndex = finalSet.size();
		}
		System.out.println(timeFrame);
	}

	private static void setNeighboursOnFire(final int[][] inputMatrix, final List<Pair> finalSet, final int startIndex,
			final int endIndex, final int rowSize, final int columnSize) {
		for (int i = startIndex; i < endIndex; i++) {
			Pair currentCell = finalSet.get(i);
			if (currentCell.getRow() - 1 >= 0 && inputMatrix[currentCell.getRow() - 1][currentCell.getColumn()] != 1) {
				inputMatrix[currentCell.getRow() - 1][currentCell.getColumn()] = 1;
				finalSet.add(new Pair(currentCell.getRow() - 1, currentCell.getColumn()));
			}

			if (currentCell.getRow() + 1 < rowSize
					&& inputMatrix[currentCell.getRow() + 1][currentCell.getColumn()] != 1) {
				inputMatrix[currentCell.getRow() + 1][currentCell.getColumn()] = 1;
				finalSet.add(new Pair(currentCell.getRow() + 1, currentCell.getColumn()));
			}

			if (currentCell.getColumn() - 1 >= 0
					&& inputMatrix[currentCell.getRow()][currentCell.getColumn() - 1] != 1) {
				inputMatrix[currentCell.getRow()][currentCell.getColumn() - 1] = 1;
				finalSet.add(new Pair(currentCell.getRow(), currentCell.getColumn() - 1));
			}

			if (currentCell.getColumn() + 1 < columnSize
					&& inputMatrix[currentCell.getRow()][currentCell.getColumn() + 1] != 1) {
				inputMatrix[currentCell.getRow()][currentCell.getColumn() + 1] = 1;
				finalSet.add(new Pair(currentCell.getRow(), currentCell.getColumn() + 1));
			}
		}

	}

	private static void findInitalSetValues(final int[][] inputMatrix, final List<Pair> finalSet, final int rowSize,
			final int columnSize) {
		for (int row = 0; row < rowSize; row++) {
			for (int column = 0; column < columnSize; column++) {
				if (inputMatrix[row][column] == 1) {
					finalSet.add(new Pair(row, column));
				}
			}
		}

	}

	static class Pair {
		private int row;
		private int column;

		Pair(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		@Override
		public String toString() {
			return "Pair [row=" + row + ", column=" + column + "]";
		}
	}

}
