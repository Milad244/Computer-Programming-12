package com.milad.module2_3;

import java.util.Comparator;

public class SortByFace implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.isFaceCard() && !o2.isFaceCard()) {
            return 1;
        } else if (!o1.isFaceCard() && o2.isFaceCard()) {
            return -1;
        }
        return 0;
    }
}
