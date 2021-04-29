package com.example.demo5;

public class MaxSumSubarray {

    public static void main(String[] args) {
        System.out.println(maxValueSubArray(new int[]{2,5,3,8,2,9,1}, 3));
    }

    public static int maxValueSubArray(final int[] input, final int size){
        if(input.length == 0 || size < 1){
            return -1;
        }
        int maxSum = 0;
        for(int i = 0; i < size; i++){
            maxSum += input[i];
        }
        int i = 1;
        int j = size;
        int tempSum = maxSum;
        while(j < input.length){
            tempSum += input[j] - input[i-1];
            i++;
            j++;
            if(tempSum > maxSum){
                maxSum = tempSum;
            }
        }
        return maxSum;
    }

}
