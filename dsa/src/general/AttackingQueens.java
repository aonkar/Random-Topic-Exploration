package com.example.demo5;

public class AttackingQueens {

    public static void main(String[] args) {
        System.out.println(nonAttackingQueens(4));
    }
    public static int nonAttackingQueens(int n) {
        int[][] matrix = new int[n][n];
        return getNonAttackingPlacements(matrix, 0, 0, 0);
    }

    public static int getNonAttackingPlacements(int[][] matrix,int row, int column, int matches){
        if(row == matrix.length && matches == matrix.length){
            return 1;
        }
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            if(isValidPosition(row, i, matrix)){
                matrix[row][i] = 1;
                count += getNonAttackingPlacements(matrix, row + 1, column, matches + 1);
                matrix[row][i] = 0;
            }
        }
        return count;
    }
    public static boolean isValidPosition(int row, int column, int[][] matrix){
        for(int i = 0; i < row; i++){
            if(matrix[i][column] == 1){
                return false;
            }
        }
        for(int i = 0; i < column; i++){
            if(matrix[row][i] == 1){
                return false;
            }
        }
        int i = row;
        int j = column;
        while(i >= 0 && j < matrix.length){
            if(matrix[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        i = row;
        j = column;
        while(i >= 0 && j >= 0){
            if(matrix[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
