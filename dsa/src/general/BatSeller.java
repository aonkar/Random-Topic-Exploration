package com.example.demo5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BatSeller {

    public static void main(String[] args) {
        final Map<String, WeightPrice> batInfo = Map
                .of("b1", new WeightPrice(1, 2),
                        "b2", new WeightPrice(3, 5),
                        "b3", new WeightPrice(9, 5),
                        "b4", new WeightPrice(7, 9),
                        "b5", new WeightPrice(985, 5),
                        "b6", new WeightPrice(65, 8));
        final Map<String, WeightPrice> cricketerInfo = Map
                .of("c1", new WeightPrice(78, 2),
                        "c2", new WeightPrice(9, 7),
                        "c3", new WeightPrice(5, 9),
                        "c4", new WeightPrice(7, 5),
                        "c5", new WeightPrice(9, 5));
        final List<List<String>> batLists = new ArrayList<>();

        cricketerInfo.forEach((key, weightPrice) -> {
            final List<String> batList = batInfo.keySet()
                    .stream()
                    .filter(batKey -> batInfo.get(batKey).getPrice() <= weightPrice.getPrice()
                            && weightPrice.getWeight() <= batInfo.get(batKey).getWeight())
                    .collect(Collectors.toList());
            if (!batList.isEmpty()) {
                batLists.add(batList);
            }
        });
        final Set<String> availableBats = new HashSet<>();
        batLists.forEach(batList -> batList.forEach(bat -> availableBats.add(bat)));
        System.out.println(calculateMaxSale(batLists, availableBats, 0, new HashMap<>()));
    }

    private static int calculateMaxSale(final List<List<String>> batLists,
                                         final Set<String> availableBats,
                                         final int index,
                                        final HashMap<Set<String>,Integer> cache) {
        if(cache.containsKey(availableBats)){
            return cache.get(availableBats);
        }
        int max = 0;
        if (index == batLists.size() || availableBats.isEmpty()) {
            System.out.println("hi");
            return 0;
        }
        final List<String> currentCricketersBatList = batLists.get(index);
        for (int i = 0; i < currentCricketersBatList.size(); i++) {
            if (availableBats.contains(currentCricketersBatList.get(i))) {
                availableBats.remove(currentCricketersBatList.get(i));
                int selected = 1 + calculateMaxSale(batLists, availableBats, index + 1, cache);
                availableBats.add(currentCricketersBatList.get(i));
                if(max < selected){
                    max = selected;
                    cache.put(availableBats, max);
                }
            } else {
                int notSelected = calculateMaxSale(batLists, availableBats, index + 1, cache);
                if(max < notSelected){
                    max = notSelected;
                    cache.put(availableBats, max);
                }
            }
        }
        return max;
    }

    public static class WeightPrice {
        private int weight;
        private int price;

        public WeightPrice(final int weight,
                           final int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }
    }
}
