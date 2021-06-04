package com.example.demo5;

public class StairClimb {

    public static void main(String[] args) {
        int stairCount = 3;
        int[] jumpSize = new int[]{1,2};
        final int count = numberOfWays(jumpSize, stairCount);
        System.out.println(count);
    }

    private static int numberOfWays(final int[] jumpSize,
                                     final int stairCount) {
        if(stairCount == 0){
            return 1;
        }
        if(stairCount < 0){
            return 0;
        }
        int count = 0;
        for(int jump: jumpSize){
            count += numberOfWays(jumpSize, stairCount - jump);
        }
        return count;
    }
}
