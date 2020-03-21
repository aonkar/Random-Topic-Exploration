package general;

public class LongestSubstringPalindrome {

	public static void main(String[] args) {
		String input = "abaxyzzyxf";
		findLongestPalindrome(input);
	}

	private static void findLongestPalindrome(String input) {

		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			int low = i - 1;
			int high = i + 1;
			int odd = getPalindrome(input, low, high);
			int even = getPalindrome(input, low, i);
			int max = odd > even ? odd : even;
			if (count < max) {
				count = max;
			}
		}
		System.out.println(count);
	}

	private static int getPalindrome(String input, int low, int high) {
		int tempCount = 1;
		while (low > 0 && high < input.length()) {
			if (input.charAt(low) == input.charAt(high)) {
				tempCount += 2;
			}
			low--;
			high++;
		}
		return tempCount;
	}
}
