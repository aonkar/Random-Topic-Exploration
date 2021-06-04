package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class SortingWithRecursion {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(1);
        list.add(4);
        list.add(17);
        list.add(-1);
        list.add(37);
        recursionSort(list);
        list.forEach(System.out::println);
    }

    private static void recursionSort(final List<Integer> list) {

        if (list.size() == 1) {
            return;
        }
        final Integer lastElement = list.remove(list.size() - 1);
        recursionSort(list);
        insertAtRightLocation(list, lastElement);
    }

    private static void insertAtRightLocation(final List<Integer> list,
                                              final Integer lastElement) {
        if (list.size() == 0) {
            list.add(lastElement);
            return;
        }
        final Integer currElement = list.remove(list.size() - 1);
        insertAtRightLocation(list, lastElement);
        if (currElement < list.get(list.size() - 1)) {
            list.add(list.size() - 1, currElement);
        } else {
            list.add(currElement);
        }
    }


}
