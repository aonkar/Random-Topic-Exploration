package com.example.demo5;

public class Monotonic {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{-1,
                -1,
                -2,
                -3,
                -4,
                -5,
                -5,
                -5,
                -6,
                -7,
                -8,
                -8,
                -9,
                -10,
                -11}));
    }

    public static boolean isMonotonic(int[] array) {
        boolean nonDecreasing = true;
        if (array == null || array.length == 0 || array.length == 1) {
            return true;
        }
        int j = 0;
        while (j < array.length - 1 && array[j] != array[j + 1]) {
            j++;
        }
        if (array[j] - array[j + 1] > 0) {
            nonDecreasing = false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (nonDecreasing) {
                if (array[i] - array[i + 1] != 0 && array[i] - array[i + 1] > 0) {
                    return false;
                }
            } else {
                if (array[i] - array[i + 1] != 0 && array[i] - array[i + 1] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
