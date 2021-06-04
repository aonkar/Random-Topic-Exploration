package com.example.demo5;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});
    }

    public static int[] smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int[] output = new int[2];
        int i = 0;
        int j = 0;
        int currentSum = Integer.MAX_VALUE;
        while(i < a.length && j < b.length){
            int diff =0;
            if(a[i] < b[j]){
                diff = b[j] - a[i];
                if(diff < currentSum){
                    output[0] = a[i];
                    output[1] = b[j];
                    currentSum = diff;
                }
                i++;
            } else if(a[i] == b[j]){
                currentSum = 0;
                output[0] = a[i];
                output[1] = b[j];
                i++;
                j++;
            }else{
                diff = a[i] - b[j];
                if(diff < currentSum){
                    output[0] = a[i];
                    output[1] = b[j];
                    currentSum = diff;
                }
                j++;
            }
        }
        return output;
    }
}
