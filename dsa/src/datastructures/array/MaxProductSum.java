package datastructures.array;

public class MaxProductSum {

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 1, 6, 3, 15, 0, 1 };
		int rotation = findMaxProductSumRotation(input);
		System.out.println("Max sum rotation : " + rotation);
	}

	private static int findMaxProductSumRotation(final Integer[] input) {
		int sum = 0;
		int produtSum = 0;
		int difference = 0;
		int rotation = 0;

		for (int i = 0; i < input.length; i++) {
			sum = sum + input[i];
			produtSum = produtSum + (i * input[i]);
		}

		for (int i = 1; i < input.length; i++) {
			int currentDiff = sum - (input.length * input[input.length - i]);
			if (currentDiff < 0 || currentDiff == 0) {
				difference = difference + currentDiff;
			} else {
				if(currentDiff - difference > 0 ) {
					difference = 0;
					rotation = i;
				} else {
					difference = difference - currentDiff;
				}
			}
		}
		return rotation;
	}

}
