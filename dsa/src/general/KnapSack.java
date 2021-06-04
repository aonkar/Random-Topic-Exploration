package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class KnapSack {

    public static void main(String[] args) {
        int size = 3;
        int[] sizes = new int[]{1,1,1};
        int[] values = new int[]{1,1,1};
        int maxValue = getMaxValue(sizes, values, size, 0, new HashMap<>());
        System.out.println(maxValue);
    }

    private static int getMaxValue(final int[] sizes,
                                   final int[] values,
                                   final int currWeightLeft,
                                   int index,
                                   Map<String, Integer> cache) {
        if (index > sizes.length - 1 || sizes[index] > currWeightLeft) {
            System.out.println("hello");
            return 0;
        }
        if(cache.containsKey(index+" " + currWeightLeft)){
            return cache.get(index+" " + currWeightLeft);
        }
        final int currentMax = Math.max(
                values[index] + getMaxValue(sizes, values, currWeightLeft - sizes[index], index + 1, cache),
                getMaxValue(sizes, values, currWeightLeft, index + 1, cache));
        cache.put(index+" " + currWeightLeft, currentMax);
        return currentMax;
    }

}
