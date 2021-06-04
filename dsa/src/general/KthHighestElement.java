package com.example.demo5;

import java.util.PriorityQueue;

public class KthHighestElement {

    public static void main(String[] args) {
        int[] input = new int[]{7,10,4,3,20,15};
        int k = 3;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i,j) -> j -i);
        for(int currentElement: input){
            maxHeap.add(currentElement);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        System.out.println(maxHeap.peek());
    }
}
