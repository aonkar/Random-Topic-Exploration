package com.example.demo5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        final String string1 = "aabcde";
        final String string2 = "abbcde";
        System.out.println(longestCommonSubsequence(string1, string2));
    }

    public static List<Character> longestCommonSubsequence(String str1,
                                                           String str2) {
        final List<Character> output = new ArrayList<>();
        if (str1.length() == 0 || str2.length() == 0) {
            return output;
        }
        String stringOutput = getLongestCommonSubsequence(str1, str2, str1.length() - 1, str2.length() - 1, new HashMap<>());
        for (int i = stringOutput.length() - 1; i > -1; i--) {
            output.add(stringOutput.charAt(i));
        }
        return output;
    }

    private static String getLongestCommonSubsequence(String str1,
                                                      String str2,
                                                      int string1Index,
                                                      int string2Index,
                                                      Map<String, String> cache) {

        if (cache.containsKey(string1Index + " " + string2Index)) {
            return cache.get(string1Index + " " + string2Index);
        }
        System.out.println("Hello");
        if (string1Index < 0 || string2Index < 0) {
            return "";
        }
        if (str1.charAt(string1Index) == str2.charAt(string2Index)) {
            String output = str1.charAt(string1Index) + getLongestCommonSubsequence(str1, str2, string1Index - 1,
                    string2Index - 1, cache);
            cache.put(string1Index + " " + string2Index, output);
            return output;
        } else {
            String withString1Selection = getLongestCommonSubsequence(str1, str2, string1Index, string2Index - 1, cache);
            String withString2Selection = getLongestCommonSubsequence(str1, str2, string1Index - 1, string2Index, cache);
            final String output = withString1Selection.length() > withString2Selection.length()
                    ? withString1Selection : withString2Selection;
            cache.put(string1Index + " " + string2Index, output);
            return output;
        }
    }
}
