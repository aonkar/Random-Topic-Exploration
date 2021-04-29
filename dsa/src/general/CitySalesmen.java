package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class CitySalesmen {
    public static void main(String[] args) {
        int[] cityA = {10,2,4,5,20,9};
        int[] cityB = {4,6,2,78,34,5};
        int travelCost = 3;
        Map<String,Integer> resultCache = new HashMap<>();

        System.out.println(calculateMaxProfit(cityA, cityB, travelCost, 0, "b", resultCache));
    }

    private static int calculateMaxProfit(final int[] cityA,
                                          final int[] cityB,
                                          final int travelCost,
                                          final int day,
                                          final String currentCity,
                                          final Map<String, Integer> resultCache) {
        if (day == cityA.length) {
            return 0;
        }
        if (currentCity.equals("a")) {
            if(resultCache.containsKey(currentCity+day)){
                return resultCache.get(currentCity+day);
            }
            System.out.println("a");
            int profitWithoutTravelling = cityA[day] + calculateMaxProfit(cityA, cityB, travelCost, day + 1, "a", resultCache);
            int profitWithTravelling = cityA[day] + calculateMaxProfit(cityA, cityB, travelCost, day + 1, "b", resultCache) - travelCost;
            int maxProfit = Math.max(profitWithoutTravelling, profitWithTravelling);
            resultCache.put(currentCity+day, maxProfit);
            return maxProfit;
        } else {
            if(resultCache.containsKey(currentCity+day)){
                return resultCache.get(currentCity+day);
            }
            System.out.println("b");
            int profitWithoutTravelling = cityB[day] + calculateMaxProfit(cityA, cityB, travelCost, day + 1, "b", resultCache);
            int profitWithTravelling = cityB[day] + calculateMaxProfit(cityA, cityB, travelCost, day + 1, "a", resultCache) - travelCost;
            int maxProfit =  Math.max(profitWithoutTravelling, profitWithTravelling);
            resultCache.put(currentCity+day, maxProfit);
            return maxProfit;
        }
    }
}
