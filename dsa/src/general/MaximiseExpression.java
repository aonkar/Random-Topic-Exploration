package com.example.demo5;

public class MaximiseExpression {

    public static void main(String[] args) {
        System.out.println(maximizeExpression(new int[]{3,
                6,
                1,
                -3,
                2,
                7}));
    }

    public static int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }
        int[] temp = new int[array.length];
        temp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > temp[i - 1]) {
                temp[i] = array[i];
            } else {
                temp[i] = temp[i - 1];
            }
        }
        int[] result1 = getMaxArray(array, temp, "-", 1);
        int[] result2 = getMaxArray(array, result1, "+", 2);
        int[] result3 = getMaxArray(array, result2, "-", 3);
        return result3[result3.length - 1];
    }

    public static int[] getMaxArray(int[] array,
                                    int[] temp,
                                    String operation,
                                    int fromIndex) {
        int currentMax = Integer.MIN_VALUE;
        int[] tempResult = new int[array.length];
        if (operation.equals("-")) {
            for (int i = fromIndex; i < array.length; i++) {
                if (temp[i-1] - array[i] > currentMax) {
                    tempResult[i] = temp[i-1] - array[i];
                    currentMax = temp[i-1] - array[i];
                } else {
                    tempResult[i] = currentMax;
                }
            }
        } else {
            for (int i = fromIndex; i < array.length; i++) {
                if (temp[i-1] + array[i] > currentMax) {
                    tempResult[i] = temp[i-1] + array[i];
                    currentMax = temp[i-1] + array[i];
                } else {
                    tempResult[i] = currentMax;
                }
            }
        }
        return tempResult;
    }
}
