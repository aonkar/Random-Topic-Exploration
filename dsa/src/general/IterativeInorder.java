package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

public class IterativeInorder {

    public static void iterativeInOrderTraversal(BinaryTree tree,
                                                 Function<BinaryTree, Void> callback) {

        BinaryTree previous = null;
        BinaryTree current = tree;
        while (current != null) {
            if(previous == null || current.parent == previous){
                if(current.left != null){
                    current = current.left;
                } else{
                    callback.apply(current);
                }
                previous = current;
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value,
                          BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
