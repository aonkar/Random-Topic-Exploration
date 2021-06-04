package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class CompareBST {

    public static void main(String[] args) {
        sameBsts(List.of(10, 15, 8, 12, 94, 81, 5, 2, 11), List.of(10, 8, 5, 15, 2, 12, 11, 94, 81));
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.size() == 0 && arrayTwo.size() == 0){
            return true;
        }
        if((arrayOne.size() == 0 && arrayTwo.size() != 0) || (arrayOne.size() != 0 && arrayTwo.size() == 0)){
            return false;
        }
        if(arrayOne.get(0) != arrayTwo.get(0)){
            return false;
        }
        if(arrayOne.size() == 1 && arrayTwo.size() == 1){
            return true;
        }
        int root = arrayOne.get(0);
        List<Integer> arrayOneLeft = new ArrayList<>();
        List<Integer> arrayOneRight = new ArrayList<>();
        List<Integer> arrayTwoLeft = new ArrayList<>();
        List<Integer> arrayTwoRight = new ArrayList<>();
        for(int i = 1; i < arrayOne.size(); i++){
            if(arrayOne.get(i) < root){
                arrayOneLeft.add(arrayOne.get(i));
            } else if(arrayOne.get(i) >= root){
                arrayOneRight.add(arrayOne.get(i));
            }
        }
        for(int i = 1; i < arrayTwo.size(); i++){
            if(arrayTwo.get(i) < root){
                arrayTwoLeft.add(arrayTwo.get(i));
            } else if(arrayTwo.get(i) >= root){
                arrayTwoRight.add(arrayTwo.get(i));
            }
        }
        return sameBsts(arrayOneLeft, arrayTwoLeft) && sameBsts(arrayOneRight, arrayTwoRight);
    }
}
