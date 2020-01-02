package datastructures.array.matrix;

import java.util.Scanner;

public class MagicMatrix {

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
		
	}

}
