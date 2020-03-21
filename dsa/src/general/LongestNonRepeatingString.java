package general;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingString {

	public static void main(String[] args) {
		System.out.println(soultion("abcabcbb"));
	}

	private static int soultion(String s) {
		Map<Character, Integer> inputMap = new HashMap<>();
		int startIndex = 0;
		int endIndex = 0;
		int length = 1;
		if (s.length() == 0) {
			return 0;
		}
		for (int i = 0; i < s.length(); i++) {
			Character currentChar = s.charAt(i);
			if (inputMap.containsKey(currentChar) && (inputMap.get(currentChar) >= startIndex)) {
				startIndex = inputMap.get(currentChar) + 1;
			}
			inputMap.put(currentChar, i);
			endIndex = i;
			if (endIndex - startIndex >= length) {
				length = endIndex - startIndex + 1;
			}
		}
		return length;

	}
}
