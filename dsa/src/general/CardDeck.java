package com.example.demo5;

public class CardDeck {

    public static void main(String[] args) {
        int[] cardValues = {-10, 1, 1, 1, 1, 1};
        System.out.println(getScore(cardValues, cardValues.length - 1, true));
        System.out.println(getScore(cardValues, cardValues.length - 1, false));
    }

    private static int getScore(final int[] cardValues,
                                final int currentSize,
                                final boolean player1) {
        if (currentSize < 0) {
            return 0;
        }
        if (!player1) {
            int score1 = getScore(cardValues, currentSize - 1, true);
            int score2 = getScore(cardValues, currentSize - 2, true);
            int score3 = getScore(cardValues, currentSize - 3, true);
            final int intermediateMax = Math.min(score1, score2);
            return Math.min(intermediateMax, score3);
        }
        int score1 = cardValues[currentSize];
        int score2 = cardValues[currentSize];
        int score3 = cardValues[currentSize];
        if (currentSize >= 0) {
            score1 += getScore(cardValues, currentSize - 1, false);
        }
        if (currentSize > 0) {
            score2 += cardValues[currentSize - 1] + getScore(cardValues, currentSize - 2, false);
        }
        if (currentSize > 1) {
            score3 += cardValues[currentSize - 1] + cardValues[currentSize - 2] + getScore(cardValues,
                    currentSize - 3, false);
        }
        final int intermediateMax = Math.max(score1, score2);
        return Math.max(intermediateMax, score3);
    }
}
