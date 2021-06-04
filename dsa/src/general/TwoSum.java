package com.example.demo5;

public class TwoSum {

    public static void main(String[] args) {
        final int[] output = twoSum(new int[]{2,
                7,
                11,
                15}, 9);
        for (int elem: output){
            System.out.println(elem);
        }
    }

    public static int[] twoSum(int[] nums,
                               int target) {
        final int[] output = new int[2];
        String outputString = getTwoSum(nums, "", 0, target);
        if (outputString.length() > 1) {
            output[0] = outputString.charAt(0) - '0';
            output[1] = outputString.charAt(1) - '0';
        }
        return output;
    }

    public static String getTwoSum(int[] nums,
                                   String output,
                                   int index,
                                   int target) {
        if (target - nums[index] == 0) {
            return output + index;
        }
        if (nums[index] > target) {
            return "";
        }

        String include = getTwoSum(nums, output + index, index + 1, target - nums[index]);
        if(include.length() > 1){
            return include;
        }
        return getTwoSum(nums, output, index + 1, target);
    }
}
