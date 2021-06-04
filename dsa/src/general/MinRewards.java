package com.example.demo5;

public class MinRewards {

    public static void main(String[] args) {
        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }

    public static int minRewards(int[] scores) {
        int[] reward = new int[scores.length];
        reward[0] = 1;
        int min = 0;
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > scores[i-1]){
                reward[i] = reward[i-1] + 1;
            } else{
                reward[i] = reward[i-1] - 1;
                if(reward[i] < min){
                    min = reward[i];
                }
            }
        }
        int sum = 0;
        if(min < 0){
            min = Math.abs(min) + 1;
        } else if(min == 0){
            min = 1;
        }
        for(int i = 0; i < reward.length; i++){
            sum += reward[i] + min;
        }
        return sum;
    }
}
