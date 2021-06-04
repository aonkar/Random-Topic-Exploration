package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class InterWeavingString {

    public static void main(String[] args) {
        System.out.println(interweavingStrings("algoexpert", "your-dream-job", "your-algodream-expertjob"));
    }

    public static boolean interweavingStrings(String one,
                                              String two,
                                              String three) {
        Map<String, Boolean> cache = new HashMap<>();
        return isMatching(one, two, three, 0, 0, 0, cache);
    }

    public static boolean isMatching(String one,
                                     String two,
                                     String three,
                                     int indexOne,
                                     int indexTwo,
                                     int indexThree,
                                     Map<String, Boolean> cache) {
        if (cache.containsKey("" + indexOne + indexTwo)) {
            return cache.get("" + indexOne + indexTwo);
        }
        if (indexThree == three.length()) {
            return true;
        }
        if (indexOne >= one.length() && indexTwo >= two.length()) {
            return false;
        }
        boolean oneStatus = false;
        boolean twoStatus = false;
        if (indexOne < one.length() && three.charAt(indexThree) == one.charAt(indexOne)) {
            oneStatus = isMatching(one, two, three, indexOne + 1, indexTwo, indexThree + 1, cache);
            cache.put("" + indexOne + indexTwo, oneStatus);
            if (oneStatus) {
                return true;
            }
        }
        if (indexTwo < two.length() && three.charAt(indexThree) == two.charAt(indexTwo)) {
            twoStatus = isMatching(one, two, three, indexOne, indexTwo + 1, indexThree + 1, cache);
            cache.put("" + indexOne + indexTwo, twoStatus);
            return twoStatus;
        }
        cache.put("" + indexOne + indexTwo, false);
        return false;
    }
}
