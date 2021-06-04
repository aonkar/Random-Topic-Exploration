package com.example.demo5;

public class FindElementInSortedMatrix {

    public static void main(String[] args) {
        searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3);
    }
        public static boolean searchMatrix(int[][] matrix, int target) {
            int i = 0;
            int j = matrix[0].length -1;
            while(i >= 0 && j < matrix[0].length){
                if(matrix[i][j] == target){
                    return true;
                }else if(matrix[i][j] < target){
                    j++;
                } else {
                    i--;
                }
            }
            return false;
        }
    }