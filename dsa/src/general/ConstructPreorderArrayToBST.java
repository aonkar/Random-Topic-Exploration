package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class ConstructPreorderArrayToBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST bst = reconstructBst(List.of(10, 4, 2, 1, 5, 17, 19, 18));
        System.out.println(bst);
    }

    static class IndexStore {
        public int index;
        public IndexStore(int index) {
            this.index = index;
        }
    }
    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        return getRootNode(preOrderTraversalValues, new IndexStore(0), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static BST getRootNode(List<Integer> preOrderTraversalValues,
                                  IndexStore indexStore,
                                  int lowerBound,
                                  int upperBound) {
        if (indexStore.index == preOrderTraversalValues.size()) {
            return null;
        }
        if (preOrderTraversalValues.get(indexStore.index) < lowerBound || preOrderTraversalValues.get(
                indexStore.index) >= upperBound) {
            return null;
        }
        BST node = new BST(preOrderTraversalValues.get(indexStore.index));
        indexStore.index += 1;
        node.left = getRootNode(preOrderTraversalValues, indexStore, lowerBound, node.value);
        node.right = getRootNode(preOrderTraversalValues, indexStore, node.value, upperBound);
        return node;
    }
}
