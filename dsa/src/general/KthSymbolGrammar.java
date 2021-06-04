package com.example.demo5;

public class KthSymbolGrammar {

    public static void main(String[] args) {
        int n = 4;
        int k = 7;
        int element = getKthElement(n, k - 1);
        System.out.println(element);
    }

    private static int getKthElement(final int n,
                                     final int k) {
        if (n == 0) {
            return 0;
        }
        if (k % 2 != 0) {
            return 1 ^ getKthElement(n - 1, k / 2);
        }
        return getKthElement(n - 1, k / 2);
    }
}
