package com.example.demo5;

public class CanJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {5,9,3,2,1,0,2,3,3,1,0,0}));
    }
    public static boolean canJump(int[] nums) {
        int i = 0;
        while(i < nums.length -1){
            if(nums[i] == 0){
                return false;
            }
            int maxJump = 0;
            int nextIndex = 0;
            for(int j = 1; j <= nums[i]; j++){
                int temp = j + i + nums[j+i];
                if(temp > maxJump){
                    maxJump = temp;
                    nextIndex = j;
                }
            }
            i = nextIndex;
        }
        return true;
    }
}
