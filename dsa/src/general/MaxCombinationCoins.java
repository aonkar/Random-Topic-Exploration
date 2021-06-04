package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class MaxCombinationCoins {

    public static void main(String[] args) {
        System.out.println(getMaxCoinCombo(new int[]{1,2,3}, new HashMap<>(), 5, 0));
    }

    private static int getMaxCoinCombo(final int[] coins,
                                       Map<String, Integer> cache,
                                       final int sum,
                                       final int fromIndex) {
        System.out.println("From Index: " + fromIndex + " sum left: " + sum);
        if (cache.containsKey(sum + " " + fromIndex)) {
            return cache.get(sum + " " + fromIndex);
        }
        System.out.println("From Index: " + fromIndex + " sum left: " + sum);
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        int count = 0;
        for (int i = fromIndex; i < coins.length; i++) {
            if (coins[i] <= sum) {
                count += getMaxCoinCombo(coins, cache, sum - coins[i], i);
                cache.put(sum + " " + fromIndex, count);
            }
        }
        return count;
    }
}
