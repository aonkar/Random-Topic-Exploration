package com.example.demo5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamWinner {

    public static void main(String[] args) {
        tournamentWinner(List.of(List.of("HTML", "C#"), List.of("C#", "Python"), List.of("Python", "HTML")), List.of(0, 0, 1));
    }

    public static String tournamentWinner(List<List<String>> competitions,
                                          List<Integer> results) {
        String team = "";
        int count = 0;
        Map<String, Integer> resultCount = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            String winner = competitions.get(i).get(results.get(i));
            if (resultCount.containsKey(winner)) {
                resultCount.put(winner, resultCount.get(winner) + 1);
            } else {
                resultCount.put(winner, 1);
            }
            if (count < resultCount.get(winner)) {
                count = resultCount.get(winner);
                team = winner;
            }
        }
        return team;
    }
}
