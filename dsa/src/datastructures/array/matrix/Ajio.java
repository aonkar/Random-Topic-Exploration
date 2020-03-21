package datastructures.array.matrix;

import java.util.Scanner;

public class Ajio {

	public static void main(String[] args) {
		final Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++) {
			Integer shops = scan.nextInt();
			Integer paths = scan.nextInt();
			int[][] costMatix = new int[shops][shops];
			int[] nearArray = new int[shops];
			for (int j = 0; j < shops; j++) {
				nearArray[j] = Integer.MIN_VALUE;
			}
			int[][] selected = new int[2][shops - 1];
			int count = 0;
			for (int j = 0; j < shops; j++) {
				costMatix[j][j] = Integer.MIN_VALUE;
			}
			int maxCost = 0;
			int currSource = -1;
			int currDest = -1;
			for (int j = 0; j < paths; j++) {
				int source = scan.nextInt() - 1;
				int destination = scan.nextInt() - 1;
				int cost = scan.nextInt();
				costMatix[source][destination] = cost;
				costMatix[destination][source] = cost;
				if (cost > maxCost) {
					maxCost = cost;
					currSource = source;
					currDest = destination;
				}
			}
			maxCost = 0;
			selected[0][count] = currSource;
			selected[1][count] = currDest;
			nearArray[currDest] = 0;
			nearArray[currSource] = 0;
			count++;
			int tempMax = Integer.MIN_VALUE;
			for (int j = 0; j < shops; j++) {
				if (nearArray[j] != 0) {
					nearArray[j] = costMatix[currDest][j] > costMatix[currSource][j] ? currDest : currSource;
					if (costMatix[j][nearArray[j]] > tempMax) {
						tempMax = costMatix[j][nearArray[j]];
						selected[0][count] = j;
						selected[1][count] = nearArray[j];
					}
				}
			}
			nearArray[selected[0][count]] = 0;
			int latestSelected = selected[0][count];
			count++;
			while (count < shops - 1) {
				tempMax = Integer.MIN_VALUE;
				for (int j = 0; j < shops; j++) {
					if (nearArray[j] != 0) {
						nearArray[j] = costMatix[j][nearArray[j]] > costMatix[j][latestSelected] ? nearArray[j]
								: latestSelected;
						if (costMatix[j][nearArray[j]] > tempMax) {
							tempMax = costMatix[j][nearArray[j]];
							selected[0][count] = j;
							selected[1][count] = nearArray[j];
						}
					}
				}
				nearArray[selected[0][count]] = 0;
				latestSelected = selected[0][count];
				count++;
			}

			for (int j = 0; j < selected[0].length; j++) {
				maxCost += costMatix[selected[0][j]][selected[1][j]];
			}
			System.out.println(maxCost);
		}
		scan.close();
	}
}
