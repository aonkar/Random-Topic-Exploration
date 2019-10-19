package algorithm;

public class HammingDistance {

	public static void main(String[] args) {
		String input1 = "Abhishek";
		String input2 = "Abihshek";
		System.out.println(findHammingDistance(input1, input2));
	}

	private static String findHammingDistance(final String input1, final String input2) {
		if (input1.length() == 0 || input1.length() != input2.length()) {
			return "Invalid input types";
		}
		final char[] input1Array = input1.toCharArray();
		final char[] input2Array = input2.toCharArray();
		int count = 0;
		for (int i = 0; i < input1Array.length; i++) {
			if(input1Array[i] != input2Array[i]) {
				count++;
			}
		}
		return String.valueOf(count);

	}

}
