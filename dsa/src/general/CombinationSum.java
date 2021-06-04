package com.example.demo5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        final List<List<Integer>> output = combinationSum2(new int[]{10,
                1,
                2,
                7,
                6,
                1,
                5}, 8);

        output.forEach(lists -> lists.forEach(System.out::println));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates,
                                                      int target) {

        Arrays.sort(candidates);
        final List<List<Integer>> finalOutput = new ArrayList<>();
        getcombinations(candidates, finalOutput, new ArrayList<>(), target, 0, false);
        return finalOutput;
    }

    public static void getcombinations(int[] candidates,
                                       List<List<Integer>> finalOutput,
                                       List<Integer> currentList,
                                       int target,
                                       int currentIndex,
                                       boolean prevSelected) {
        if (target == 0) {
            finalOutput.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0 || currentIndex == candidates.length) {
            return;
        }
        if(currentIndex == 0 || candidates[currentIndex] != candidates[currentIndex-1] || (candidates[currentIndex] == candidates[currentIndex-1] && prevSelected)){
            currentList.add(candidates[currentIndex]);
            getcombinations(candidates, finalOutput, currentList, target - candidates[currentIndex], currentIndex + 1, true);
            currentList.remove(currentList.size() - 1);
        }
        getcombinations(candidates, finalOutput, currentList, target, currentIndex + 1, false);
    }
}
