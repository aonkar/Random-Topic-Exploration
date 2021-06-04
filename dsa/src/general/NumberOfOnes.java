package com.example.demo5;

public class NumberOfOnes {

    public static void main(String[] args) {
        String output = generatePattern(5, 0, 0, "");
        System.out.println(output);
    }

    private static String generatePattern(final int inputSize, int countZero, int countOne, String output) {
        if(inputSize == 0){
            return output;
        }
        if(countZero < countOne - 1){
            return generatePattern(inputSize - 1, countZero + 1, countOne, output + "0");
        } else{
            return generatePattern(inputSize - 1, countZero, countOne + 1, output + "1");
        }
    }
}
