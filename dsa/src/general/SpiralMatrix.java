package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        spiralTraverse(new int[][]
                {{1,
                        2,
                        3,
                        4},
                        {10,
                                11,
                                12,
                                5},
                        {9,
                                8,
                                7,
                                6}}).forEach(System.out::println);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        final List<Integer> output = new ArrayList<>();
        int topRow = 0;
        int startColumn = 0;
        int bottomRow = array.length - 1;
        int endColumn = array[0].length - 1;
        while (topRow <= bottomRow && startColumn <= endColumn) {
            for (int i = startColumn; i <= endColumn; i++) {
                output.add(array[topRow][i]);
            }
            topRow++;
            for (int i = topRow; i <= bottomRow; i++) {
                output.add(array[i][endColumn]);
            }
            endColumn--;
            if(topRow <= bottomRow)
            for (int i = endColumn; i >= startColumn; i--) {
                output.add(array[bottomRow][i]);
            }
            bottomRow--;
            if(startColumn <= endColumn)
            for (int i = bottomRow; i >= topRow; i--) {
                output.add(array[i][startColumn]);
            }
            startColumn++;
        }
        return output;
    }
}
