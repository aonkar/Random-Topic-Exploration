package com.example.demo5;

public class MinSortArray {

    public static void main(String[] args) {
        final int[] output = subarraySort(new int[]{2,1});
        System.out.println(output[0] + ", " + output[1]);
    }

    public static int[] subarraySort(int[] array) {
        int startIndex = -1;
        int endIndex = -1;
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                if (startIndex == -1) {
                    startIndex = i + 1;
                } else {
                    endIndex = i + 2;
                }
            }
        }
        if(startIndex != -1 && endIndex == -1){
            endIndex = startIndex;
        }
        if(startIndex != -1){
            startIndex = findStartingIndex(array,array[startIndex]);
        }
        output[0] =startIndex;
        output[1] =endIndex;
        return output;
    }

    private static int findStartingIndex(final int[] array,
                                         final int findTerm) {
        int i = 0;
        while(i < array.length){
            if(array[i] >= findTerm){
                return i;
            }
            i++;
        }
        return -1;
    }
}
