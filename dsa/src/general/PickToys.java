package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class PickToys {

    public static void main(String[] args) {
        System.out.println(pickToys(new Character[]{'a','b','a','c'}, 2));
    }
    public static int pickToys(final Character[] toys, final int types){
        int i = 0;
        int j = 1;
        int maxCount = 1;
        final Map<Character,Integer> toysCountMap = new HashMap<>();
        toysCountMap.put(toys[0], 1);
        while(j < toys.length){
            if(toysCountMap.containsKey(toys[j])){
                toysCountMap.put(toys[j], toysCountMap.get(toys[j]) + 1);
            } else{
                toysCountMap.put(toys[j], 1);
                while(toysCountMap.size() > types){
                    if(maxCount < j - i){
                        maxCount = j -i;
                    }
                    toysCountMap.put(toys[i], toysCountMap.get(toys[i]) - 1);
                    if(toysCountMap.get(toys[i]) == 0){
                        toysCountMap.remove(toys[i]);
                    }
                    i++;
                }
            }
            j++;
        }
        if(maxCount < j - i){
            maxCount = j -i;
        }
        return maxCount;
    }
}
