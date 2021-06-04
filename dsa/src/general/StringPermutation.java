package com.example.demo5;

public class StringPermutation {

    public static void main(String[] args) {
        printPermutations(new Character[]{'a','b', 'c'}, 0, "");
    }
    public static void printPermutations(Character[] input, int index, String currString){
        if(index == input.length){
            System.out.println(currString);
            return;
        }
        printPermutations(input, index+1, currString + input[index]);
        printPermutations(input, index+1, currString);
    }
}
