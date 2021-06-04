package com.example.demo5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JobSchedulerOrder {

    public static void main(String[] args) {
        topologicalSort(List.of(1, 2, 3, 4), List.of(
                new Integer[]{1, 2},
                new Integer[]{1, 3},
                new Integer[]{3, 2},
                new Integer[]{4, 2},
                new Integer[]{4, 4})).forEach(System.out::println);
    }

    public static List<Integer> topologicalSort(List<Integer> jobs,
                                                List<Integer[]> deps) {
        final Map<Integer, List<Integer>> dependecies = new HashMap<>();
        Integer[] array = new Integer[10];
        array[0] = 1;
        final List<Integer> test = Arrays.stream(array).collect(Collectors.toList());
        test.set(0, 2);
        final Set<Integer> processed = new HashSet<>();
        final List<Integer> output = new ArrayList<>();
        deps.forEach(pair -> {
            dependecies.compute(pair[1], (key, value) -> {
                if (value == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(pair[0]);
                    return list;
                } else {
                    value.add(pair[0]);
                    return value;
                }
            });
        });
        for (int i = 0; i < jobs.size(); i++) {
            int job = jobs.get(i);
            if (!processed.contains(job)) {
                if (dependecies.containsKey(job)) {
                    if (!processedJob(job, dependecies, processed, output)) {
                        return new ArrayList<>();
                    }
                } else {
                    output.add(job);
                    processed.add(job);
                }
            }
        }
        return output;
    }

    private static boolean processedJob(final int job,
                                        final Map<Integer, List<Integer>> dependecies,
                                        final Set<Integer> processed,
                                        final List<Integer> output) {
        final Deque<Integer> stack = new ArrayDeque<>();
        final Set<Integer> processing = new HashSet<>();
        stack.push(job);
        while (!stack.isEmpty()) {
            final Integer currElement = stack.peek();
            if (processed.contains(currElement)) {
                stack.pop();
                continue;
            }
            if (!notAllExplored(dependecies, currElement, processed)) {
                output.add(currElement);
                processed.add(currElement);
                continue;
            }
            processing.add(currElement);
            List<Integer> jobDependency = dependecies.get(currElement);
            for (int i = 0; i < jobDependency.size(); i++) {
                if (processing.contains(jobDependency.get(i))) {
                    return false;
                }
                stack.push(jobDependency.get(i));
            }
        }
        return true;
    }

    private static boolean notAllExplored(final Map<Integer, List<Integer>> dependecies,
                                          final Integer currElement,
                                          final Set<Integer> processed) {

        List<Integer> jobDependency = dependecies.get(currElement);
        if (jobDependency == null) {
            return false;
        }
        return jobDependency.stream().anyMatch(job -> !processed.contains(job));
    }
}
