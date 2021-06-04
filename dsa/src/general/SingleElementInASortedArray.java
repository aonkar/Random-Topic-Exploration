package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
    public static int singleNonDuplicate(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();

        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (high + low) / 2;
            if((mid == 0 || nums[mid] != nums[mid-1])
                    && (mid == nums.length -1 ||nums[mid] != nums[mid+1])){
                return nums[mid];
            } else if((mid % 2 == 0 && nums[mid+1] == nums[mid])
                    || (mid % 2 != 0 && nums[mid-1] == nums[mid])){
                low = mid +1;
            } else{
                high = mid -1;
            }
        }
        return -1;
    }
}
