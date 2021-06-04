package com.example.demo5;

public class BSTSearch {

    public static int findClosestValueInBst(BST tree, int target) {
        if(tree == null){
            return Integer.MAX_VALUE;
        }
        if(tree.value == target){
            return target;
        }
        if(tree.left != null && tree.value > target){
            int temp1 = tree.value - target;
            int temp2 = findClosestValueInBst(tree.left, target);
            return temp1 > Math.abs(temp2) ? temp2 : tree.value;
        } else{
            int temp1 = target - tree.value;
            int temp2 = findClosestValueInBst(tree.right, target);
            return temp1 > Math.abs(temp2) ? temp2 : tree.value;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}