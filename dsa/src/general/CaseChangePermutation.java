package com.example.demo5;

public class CaseChangePermutation {
    public static void main(String[] args) {
        printCaseChangePermutation(new char[]{'a','b', 'c'}, 0, "");
    }

    private static void printCaseChangePermutation(final char[] input, int currentIndex, String output) {

        if(currentIndex == input.length){
            System.out.println(output);
            return;
        }
        printCaseChangePermutation(input,currentIndex + 1, output + Character.toUpperCase(input[currentIndex]));
        printCaseChangePermutation(input,currentIndex + 1, output + input[currentIndex]);
    }
}
