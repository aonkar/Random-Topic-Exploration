package general;

public class StaircaseProblem {

	public static void main(String[] args) {
		int[] calculated = new int[5];
		System.out.println(numOfWays(5, calculated));
	}

	private static int numOfWays(int steps, int[] calculated) {
		if (steps <= 1) {
			return 1;
		}
		if (calculated[steps - 1] == 0) {
			calculated[steps - 1] = numOfWays(steps - 1, calculated);
		}
		if (calculated[steps - 2] == 0) {
			calculated[steps - 2] = numOfWays(steps - 2, calculated);
		}
		return calculated[steps - 1] + calculated[steps - 2];
	}
}