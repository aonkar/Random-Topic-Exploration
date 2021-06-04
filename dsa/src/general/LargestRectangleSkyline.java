package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LargestRectangleSkyline {

    public static void main(String[] args) {
        System.out.println(largestRectangleUnderSkyline(List.of(1, 3, 3, 2, 4, 1, 5, 3, 2)));
    }

    public static int largestRectangleUnderSkyline(List<Integer> buildings) {
        Deque<Integer> nearestRightStack = new ArrayDeque<>();
        Deque<Integer> nearestLeftStack = new ArrayDeque<>();
        int[] right = new int[buildings.size()];
        int[] left = new int[buildings.size()];
        for (int i = buildings.size() - 1; i >= 0; i--) {
            if (i == buildings.size() - 1) {
                right[i] = buildings.size();
                nearestRightStack.push(i);
            } else {
                if (buildings.get(i) > buildings.get(nearestRightStack.peek())) {
                    right[i] = nearestRightStack.peek();
                    nearestRightStack.push(i);
                } else {
                    int temp = buildings.size();
                    while (!nearestRightStack.isEmpty()
                            && buildings.get(nearestRightStack.peek()) >= buildings.get(i)) {
                        nearestRightStack.pop();
                    }
                    if (!nearestRightStack.isEmpty()) {
                        temp = nearestRightStack.peek();
                    }
                    nearestRightStack.push(i);
                    right[i] = temp;
                }
            }
        }
        for (int i = 0; i < buildings.size(); i++) {
            if (i == 0) {
                left[i] = -1;
                nearestLeftStack.push(i);
            } else {
                if (buildings.get(i) > buildings.get(nearestLeftStack.peek())) {
                    left[i] = nearestLeftStack.peek();
                    nearestLeftStack.push(i);
                } else {
                    int temp = -1;
                    while (!nearestLeftStack.isEmpty()
                            && buildings.get(nearestLeftStack.peek()) >= buildings.get(i)) {
                        nearestLeftStack.pop();
                    }
                    if (!nearestLeftStack.isEmpty()) {
                        temp = nearestLeftStack.peek();
                    }
                    nearestLeftStack.push(i);
                    left[i] = temp;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < right.length; i++) {
            int temp = (right[i] - left[i] - 1) * buildings.get(i);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
