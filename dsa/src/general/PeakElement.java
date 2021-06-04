package com.example.demo5;

public class PeakElement {

    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }

    public static int longestPeak(int[] array) {
        if (array.length < 3) {
            return 0;
        }
        int i = 0;
        int count = 0;
        int max = 0;
        boolean peakFound = false;
        while (i < array.length - 1) {
            if (array[i] < array[i + 1] && !peakFound) {
                count++;
            } else if (array[i] < array[i + 1] && peakFound) {
                if (max < count + 1) {
                    max = count + 1;
                    count = 0;
                }
            } else if (array[i] > array[i + 1] && count > 0) {
                peakFound = true;
                count++;
            }
            i++;
        }
        return max;
    }
}
