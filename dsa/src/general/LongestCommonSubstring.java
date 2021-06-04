package com.example.demo5;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        final String string1 = "aab";
        final String string2 = "a";
        final int[][] cahceMatrix = new int[string1.length() + 1][ string2.length() + 1];
        for(int i = 0; i < cahceMatrix[0].length; i++){
            cahceMatrix[0][i] = 0;
        }
        for(int i = 0; i < cahceMatrix.length; i++){
            cahceMatrix[i][0] = 0;
        }
        System.out.println(getLongestCommonSubstring(string1, string2,cahceMatrix));
    }

    private static int getLongestCommonSubstring(final String string1,
                                                 final String string2,
                                                 int[][] cahceMatrix) {
        int maxCount = 0;
        for(int i = 1; i < cahceMatrix.length; i++){
            for(int j = 1; j < cahceMatrix[0].length; j++){
                if(string1.charAt(i-1) == string2.charAt(j-1)){
                    cahceMatrix[i][j] = 1 + cahceMatrix[i-1][j-1];
                    if(cahceMatrix[i][j] > maxCount){
                        maxCount = cahceMatrix[i][j];
                    }
                } else{
                    cahceMatrix[i][j] = 0;
                }
            }
        }
        return maxCount;
    }
}
