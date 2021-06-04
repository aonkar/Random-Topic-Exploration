package com.example.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhone {

    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        final Map<Integer, List<String>> phoneText = Map.of(2, List.of("a","b","c"),
                3, List.of("d","e","f"),
                4, List.of("g","h","i"),
                5, List.of("j","k","l"),
                6, List.of("m","n","o"),
                7, List.of("p","q","r", "s"),
                8, List.of("t","u","v"),
                9, List.of("w","x","y", "z"));
        final List<String> output = new ArrayList<>();
        getTextCombination(digits, output, phoneText, 0, "");
        return output;

    }
    public static void getTextCombination(String digits, List<String> output, Map<Integer, List<String>> phoneText, int index,
                                          String currString){
        if(currString.length() == digits.length()){
            output.add(currString);
            return;
        }
        final int currentNumber = digits.charAt(index) - '0';
        phoneText.get(currentNumber).forEach(letter -> {
            getTextCombination(digits, output, phoneText, index + 1, currString + letter);
        });

    }
}
