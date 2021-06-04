package com.example.demo5;

public class SpacePermutation {
    public static void main(String[] args) {

        printSpacePermutation(new char[]{'a','b', 'c'}, 0, "");
    }

    private static void printSpacePermutation(final char[] input, int currentIndex, String output) {

        if(currentIndex == input.length -1){
            System.out.println(output + input[input.length - 1]);
            return;
        }
        printSpacePermutation(input,currentIndex + 1, output + input[currentIndex] + " ");
        printSpacePermutation(input,currentIndex + 1, output + input[currentIndex]);
    }
}
