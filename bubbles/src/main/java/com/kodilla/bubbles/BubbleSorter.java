package com.kodilla.bubbles;

import java.util.List;

public class BubbleSorter {

    public List<Integer> sort(List<Integer> list){
        for (int n = list.size()-1; n > 0; n--) {
            for (int i = 0; i < n; i++) {
                if (list.get(i) > list.get(i+1)) {
                    Integer next = list.get(i+1);
                    list.set(i+1, list.get(i));
                    list.set(i, next);
                }
            }
        }
        return list;
    }
}
