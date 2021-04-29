package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRep(new Character[]{'a', 'b', 'c', 'd', 'a', 'a', 'b', 'd', 'c', 'e'}));
    }

    public static int longestSubstringWithoutRep(final Character[] input) {
        final Map<Character, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int i = 0;
        int j = 1;
        countMap.put(input[0], 1);
        while (j < input.length) {
            if (countMap.containsKey(input[j])) {
                if (j - i > maxCount) {
                    maxCount = j - 1;
                }
                countMap.put(input[j], countMap.get(input[j]) + 1);
                while (countMap.size() != (j - i) + 1) {
                    if (countMap.get(input[i]) == 1) {
                        countMap.remove(input[i]);
                    } else {
                        countMap.put(input[i], countMap.get(input[j]) - 1);
                    }
                    i++;
                }
            } else {
                countMap.put(input[j], 1);
            }
            j++;
        }
        if (j - i > maxCount) {
            maxCount = j - i;
        }
        return maxCount;
    }

}

