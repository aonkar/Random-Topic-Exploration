package com.example.demo5;

public class ValidateThreeNodes {
    public static void main(String[] args) {

    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if(nodeTwo.value  > nodeOne.value && nodeTwo.value  > nodeThree.value){
            return false;
        }
        if(nodeTwo.value  < nodeOne.value && nodeTwo.value  < nodeThree.value){
            return false;
        }
        if(nodeTwo.value > nodeThree.value){
            return isDescendant(nodeThree,nodeTwo) && isDescendant(nodeTwo,nodeOne);
        }
        return isDescendant(nodeTwo, nodeThree) && isDescendant(nodeOne, nodeTwo);
    }

    public static boolean isDescendant(BST rootNode, BST descendant){
        if(rootNode == null){
            return false;
        }
        if(rootNode.value == descendant.value){
            return true;
        }
        if(rootNode.value > descendant.value){
            return isDescendant(rootNode.left, descendant);
        }
        return isDescendant(rootNode.right, descendant);
    }
}
