package com.example.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    public static void main(String[] args) {
        phoneNumberMnemonics("1905");
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<Character, List<String>> keyPad = Map.of('1', List.of("1"),
                '2', List.of("a","b", "c"),
                '3', List.of("d","e", "f"),
                '4', List.of("g","h", "i"),
                '5', List.of("j","k", "l"),
                '6', List.of("m","n", "o"),
                '7', List.of("p","q", "r", "s"),
                '8', List.of("t","u", "v"),
                '9', List.of("w","x", "y", "z"),
                '0', List.of("0"));
        ArrayList<String> output = new ArrayList<>();
        if(phoneNumber.length() == 0){
            return output;
        }
        getTextCombination(phoneNumber, keyPad, output, "", 0);
        return output;
    }

    public static void getTextCombination(String phoneNumber, Map<Character, List<String>> keyPad, ArrayList<String> output,
                                    String tempOutput, int index){
        if(index == phoneNumber.length()){
            output.add(tempOutput);
            return;
        }
        char key = phoneNumber.charAt(index);
        List<String> letters = keyPad.get(key);
        for(int i = 0; i < letters.size(); i++){
            getTextCombination(phoneNumber, keyPad, output, tempOutput + letters.get(i), index + 1);
        }
    }
}
