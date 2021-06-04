package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstringRecursion {

    public static void main(String[] args) {
        final String string1 = "aab";
        final String string2 = "a";
        System.out.println(longestCommonSubsequence(string1, string2));
    }

    public static int longestCommonSubsequence(String str1,
                                               String str2) {

        return getLongestCommonSubstring(str1, str2, str1.length() - 1, str2.length() - 1, new HashMap<>(), 0);
    }

    private static int getLongestCommonSubstring(String str1,
                                                 String str2,
                                                 int string1Index,
                                                 int string2Index,
                                                 Map<String, Integer> cache,
                                                 int count) {
        if (cache.containsKey(string1Index + " " + string2Index)) {
            return count;
        }
        if (string1Index < 0 || string2Index < 0) {
            return 0;
        }
        int maxCount = 0;
        if (str1.charAt(string1Index) == str2.charAt(string2Index)) {
            cache.put(string1Index + " " + string2Index, count + 1);
            if (maxCount < count + 1) {
                maxCount = count + 1;
            }
            getLongestCommonSubstring(str1, str2, string1Index - 1,
                    string2Index - 1, cache, count + 1);
        }
        getLongestCommonSubstring(str1, str2, string1Index, string2Index - 1, cache, 0);
        getLongestCommonSubstring(str1, str2, string1Index - 1, string2Index, cache, 0);
        return maxCount;
    }
}
