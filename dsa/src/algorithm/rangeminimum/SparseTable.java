package algorithm.rangeminimum;

public class SparseTable {

	public static void main(String[] args) {
		Integer[] array = new Integer[] { 2, 4, 1, 7, 8, -1 };
		final Integer[][] sparseMatrix = new Integer[array.length][findLogBase2(array.length) + 1];
		Integer lowerIndex = 0;
		Integer higherIndex = 5;
		Integer index = findMinimumElement(array, sparseMatrix, lowerIndex, higherIndex);
		System.out.println("Index : " + index);

	}

	private static int findLogBase2(int size) {
		return (int) (Math.log(size) / Math.log(2));
	}

	private static Integer findMinimumElement(Integer[] array, Integer[][] sparseMatrix, Integer lowerIndex,
			Integer higherIndex) {
		generateTheSparseTableMatrix(array, sparseMatrix);
		return null;
	}

	private static void generateTheSparseTableMatrix(Integer[] array, Integer[][] sparseMatrix) {
		System.out.println(sparseMatrix[0].length);
	}

}
