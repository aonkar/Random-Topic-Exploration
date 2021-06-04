package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class AmbigiousMeasuringCup {

    public static void main(String[] args) {
        ambiguousMeasurements(new int[][]{
                {200, 210},
                {450, 465},
                {800, 850}}, 2100, 2300);
    }

    public static boolean ambiguousMeasurements(int[][] measuringCups,
                                                int low,
                                                int high) {
        Map<String, Boolean> cache = new HashMap<>();
        return getambiguousMeasurements(measuringCups, low, high, 0, 0, 0, cache);
    }

    public static boolean getambiguousMeasurements(int[][] measuringCups,
                                                   int low,
                                                   int high,
                                                   int currIndex,
                                                   int currLow,
                                                   int currHigh,
                                                   final Map<String, Boolean> cache) {
        if (cache.containsKey("" + currLow + ";" + currHigh)) {
            return cache.get("" + currLow + ";" + currHigh);
        }
        System.out.println("Currlow: " + currLow + ", CurrHigh: " + currHigh + ", CurrIndex: " + currIndex);
        if (currLow >= low && currHigh <= high) {
            return true;
        }
        if (currHigh > high) {
            return false;
        }

        for (int i = currIndex; i < measuringCups.length; i++) {
            final boolean tempResult = getambiguousMeasurements(measuringCups, low, high, i, measuringCups[i][0] + currLow,
                    measuringCups[i][1] + currHigh,
                    cache);
            cache.put("" + currLow + ";" + currHigh, tempResult);
            if (tempResult) {
                return true;
            }
        }
        return false;
    }
}
