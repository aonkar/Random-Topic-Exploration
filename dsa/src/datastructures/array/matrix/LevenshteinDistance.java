package datastructures.array.matrix;

public class LevenshteinDistance {

	public static void main(String[] args) {
		System.out.println(levenshteinDistance("abc", "abcx"));
	}

	public static int levenshteinDistance(String str1, String str2) {
		if(str1.length() == 0) {
			return str2.length();
		} else if(str2.length() == 0) {
			return str1.length();
		}
		int[][] costMatrix = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			costMatrix[i][0] = i;
		}
		for (int j = 0; j <= str2.length(); j++) {
			costMatrix[0][j] = j;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					costMatrix[i][j] = costMatrix[i - 1][j - 1];
				} else {
					costMatrix[i][j] = 1 + (costMatrix[i - 1][j] < costMatrix[i - 1][j - 1]
							? (costMatrix[i - 1][j] < costMatrix[i][j - 1] ? costMatrix[i - 1][j]
									: costMatrix[i][j - 1])
							: (costMatrix[i - 1][j - 1] < costMatrix[i][j - 1] ? costMatrix[i - 1][j - 1]
									: costMatrix[i][j - 1]));

				}
			}
		}

		return costMatrix[str1.length()][str2.length()];
	}
}
