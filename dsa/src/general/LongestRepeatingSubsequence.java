package com.example.demo5;

public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        final String input = "abbbcdddbce";
        int count = getLongestRepeatingSubsequence(input, input, input.length() - 1, input.length() - 1);
        System.out.println(count);
    }

    private static int getLongestRepeatingSubsequence(final String input1,
                                                      final String input2,
                                                      final int input1Index,
                                                      final int input2Index) {
        if (input1Index < 0 || input2Index == 0) {
            return 0;
        }
        if (input1.charAt(input1Index) == input2.charAt(input2Index) && input1Index != input2Index) {
            return 1 + getLongestRepeatingSubsequence(input1, input2, input1Index - 1, input2Index - 1);
        } else {
            return Math.max(getLongestRepeatingSubsequence(input1, input2, input1Index - 1, input2Index),
                    getLongestRepeatingSubsequence(input1, input2, input1Index, input2Index - 1));
        }
    }
}
