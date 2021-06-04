package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    public static void main(String[] args) {
        int numberOfPpl = 5;
        int interval = 2;
        final List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numberOfPpl; i++){
            list.add(i+1);
        }
        findJosephus(interval, list, 0);
    }

    private static void findJosephus(final int interval,
                                     final List<Integer> list,
                                     final int offset) {
        if(list.size() == 1){
            list.forEach(System.out::println);
            return;
        }
        int mod = (offset + interval - 1) % (list.size()) ;
        list.remove(mod);
        findJosephus(interval,list, mod);
    }
}
