package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static void main(String[] args) {
        int[] output = largestRange(new int[]{4, 2, 1, 3, 6});
        System.out.println(output[0] + " " + output[1]);
    }
    public static int[] largestRange(int[] array) {
        int[] ans = new int[2];
        Map<Integer, Boolean> found = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            found.put(array[i], true);
        }
        int count = -1;
        for(int i = 0; i < array.length; i++){
            int currentNumber = array[i]+1;
            while(found.containsKey(currentNumber) && found.get(currentNumber)){
                found.put(currentNumber, false);
                currentNumber++;
            }
            int upward = currentNumber - 1;
            currentNumber = array[i]-1;
            while(found.containsKey(currentNumber) && found.get(currentNumber)){
                found.put(currentNumber, false);
                currentNumber--;
            }
            int downward = currentNumber + 1;
            if(count < upward - downward){
                ans[0] = downward;
                ans[1] = upward;
                count= upward - downward;
            }
        }
        return ans;
    }
}
