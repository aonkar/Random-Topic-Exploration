package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class MinCoinsForSum {

    public static void main(String[] args) {
        int count = getMinCoinsForSum(new int[]{25, 10, 5}, new HashMap<>(),30, 0);
        System.out.println(count);
    }

    private static int getMinCoinsForSum(final int[] coins,
                                         Map<String, Integer> cache,
                                          final int currSum,
                                         final int fromIndex) {
        if (cache.containsKey(currSum + " " + fromIndex)) {
            return cache.get(currSum + " " + fromIndex);
        }
        if(currSum == 0){
            return 0;
        }
        int minCount = Integer.MAX_VALUE;
        for(int i = fromIndex; i < coins.length; i++){
            if(coins[i] <= currSum){
                int temp = getMinCoinsForSum(coins,cache, currSum - coins[i], i);
                if(temp != Integer.MAX_VALUE && temp < minCount){
                    minCount = 1 + temp;
                    cache.put(currSum + " " + fromIndex, minCount);
                }
            }
        }
        return minCount;
    }
}
