package com.example.demo5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sudoku {

    public static void main(String[] args) {

        List<List<Integer>> board = List.of(Arrays.stream(new Integer[]{7,
                        8,
                        0,
                        4,
                        0,
                        0,
                        1,
                        2,
                        0}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{6,
                        0,
                        0,
                        0,
                        7,
                        5,
                        0,
                        0,
                        9}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{0,
                        0,
                        0,
                        6,
                        0,
                        1,
                        0,
                        7,
                        8}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{0,
                        0,
                        7,
                        0,
                        4,
                        0,
                        2,
                        6,
                        0}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{0,
                        0,
                        1,
                        0,
                        5,
                        0,
                        9,
                        3,
                        0}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{9,
                        0,
                        4,
                        0,
                        6,
                        0,
                        0,
                        0,
                        5}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{0,
                        7,
                        0,
                        3,
                        0,
                        0,
                        0,
                        1,
                        2}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{1,
                        2,
                        0,
                        0,
                        0,
                        7,
                        4,
                        0,
                        0}).collect(Collectors.toList()),
                Arrays.stream(new Integer[]{0,
                        4,
                        9,
                        2,
                        0,
                        6,
                        0,
                        0,
                        7}).collect(Collectors.toList()));
        solveSudoku(board);
        System.out.println(board);
    }

    public static List<List<Integer>> solveSudoku(List<List<Integer>> board) {
        System.out.println(solveSubSudoku(board, 0, 0));
        return board;
    }

    public static boolean solveSubSudoku(List<List<Integer>> board,
                                         int row,
                                         int column) {
        int currentRow = row;
        int currentColumn = column;
        if (currentColumn == board.get(currentRow).size()) {
            currentColumn = 0;
            currentRow += 1;
            if (currentRow == board.size()) {
                return true;
            }
        }
        if (board.get(currentRow).get(currentColumn) == 0) {
            return tryDigitCombination(board, currentRow, currentColumn);
        }
        return solveSubSudoku(board, currentRow, currentColumn + 1);
    }

    private static boolean tryDigitCombination(final List<List<Integer>> board,
                                               final int currentRow,
                                               final int currentColumn) {
        for (int i = 1; i < 10; i++) {
            if (isValidTempNumber(i, currentRow, currentColumn, board)) {
                board.get(currentRow).set(currentColumn, i);
                if (solveSubSudoku(board, currentRow, currentColumn + 1)) {
                    return true;
                }
            }
        }
        board.get(currentRow).set(currentColumn, 0);
        return false;
    }

    public static boolean isValidTempNumber(int number,
                                            int row,
                                            int column,
                                            List<List<Integer>> board) {
        for (int i = 0; i < board.get(row).size(); i++) {
            if (number == board.get(row).get(i)) {
                return false;
            }
        }
        for (int i = 0; i < board.size(); i++) {
            if (number == board.get(i).get(column)) {
                return false;
            }
        }
        int gridColumn = column / 3;
        int gridRow = row / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.get(gridRow * 3 + i).get(gridColumn * 3 + j) == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
