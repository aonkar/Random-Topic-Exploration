package com.example.demo5;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthHighestFrequency {

    public static void main(String[] args) {
        final PriorityQueue<Integer> maxHeap = topKFrequency(new int[]{1,1,1,3,2,2,4, 3,3});
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
    }
    private static PriorityQueue<Integer> topKFrequency(final int[] input){
        final Map<Integer,Integer> numberCountMap = new HashMap<>();
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> numberCountMap.get(b) - numberCountMap.get(a));

        for(int i = 0; i < input.length; i++){
            numberCountMap.compute(input[i], (key,value) -> value == null ? 1 : value + 1);
        }
        numberCountMap.keySet().forEach(key -> {
            maxHeap.add(key);
        });
        return maxHeap;
    }

}
