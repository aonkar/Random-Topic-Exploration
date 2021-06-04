package com.example.demo5;

public class Kadens {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > currSum + nums[i]){
                currSum = nums[i];
            } else{
                currSum += nums[i];
            }
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}
