package com.milad.module2_3;

import java.util.Comparator;

public class SortByValue implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getValue() > o2.getValue()) {
            return 1;
        } else if (o1.getValue() < o2.getValue()) {
            return -1;
        }
        return 0;
    }
}
