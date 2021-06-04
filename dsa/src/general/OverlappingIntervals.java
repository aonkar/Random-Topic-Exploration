package com.example.demo5;

import java.util.Arrays;

public class OverlappingIntervals {

    public static void main(String[] args) {
        mergeOverlappingIntervals(new int[][] {{-5, -4},
        {-4, -3},
        {-3, -2},
        {-2, -1},
        {-1, 0}});
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] output = new int[intervals.length][2];
        for(int i = 0; i < output.length; i++){
            for(int j = 0; j < output[0].length; j++){
                output[i][j] = Integer.MIN_VALUE;
            }
        }
        output[0][0] = intervals[0][0];
        output[0][1] = intervals[0][1];
        int i = 1;
        int j = 0;
        while (i < intervals.length) {
            if (output[j][1] < intervals[i][0]) {
                j++;
                output[j][0] = intervals[i][0];
                output[j][1] = intervals[i][1];
            } else {
                output[j][1] = intervals[i][1] > output[j][1] ? intervals[i][1] : output[j][1];
            }
            i++;
        }
        return Arrays.stream(output).filter(input -> input[0] != Integer.MIN_VALUE && input[1] != Integer.MIN_VALUE).toArray(int[][]::new);
    }
}
