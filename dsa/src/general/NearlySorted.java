package com.example.demo5;

import java.util.List;
import java.util.PriorityQueue;

public class NearlySorted {

    public static void main(String[] args) {
        sortKSortedArray(new int[]{3,
                2,
                1,
                5,
                4,
                7,
                6,
                5}, 3);
    }

    public static int[] sortKSortedArray(int[] array,
                                         int k) {
        // Write your code here.
        final int[] output = new int[array.length];
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            minHeap.add(array[i]);
        }
        int currentKIndex = k + 1;
        for (int i = 0; i < array.length; i++) {
            output[i] = minHeap.remove();
            if (currentKIndex < array.length) {
                minHeap.add(array[currentKIndex]);
            }
            currentKIndex++;
        }
        return output;
    }
}
