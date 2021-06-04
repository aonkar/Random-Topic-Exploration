package com.example.demo5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfMostFrequent {

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1,2,4}, 5));
    }
    public static int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        return getMaxFrequency(nums, k, 0);
    }

    public static int getMaxFrequency(int[] nums, int k, int index){

        if(k == 0 || index == nums.length - 1){
            Map<Integer, Integer> countMap = new HashMap<>();
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                if(countMap.get(nums[i]) == null){
                    countMap.put(nums[i],1);
                } else{
                    countMap.put(nums[i],countMap.get(nums[i]) + 1);
                }
                if(countMap.get(nums[i]) > max){
                    max = countMap.get(nums[i]);
                }
            }
            return max;
        }
        int withSelection = 0;
        int withOutSelection = 0;
        if(nums[index+1] - nums[index] <= k){
            final int temp = nums[index];
            nums[index] = nums[index+1];
            withSelection = getMaxFrequency(nums, k - (nums[index+1] - temp), index+1);
            nums[index] = temp;
        }
        withOutSelection = getMaxFrequency(nums, k, index+1);

        return withSelection > withOutSelection ? withSelection : withOutSelection;

    }
}
