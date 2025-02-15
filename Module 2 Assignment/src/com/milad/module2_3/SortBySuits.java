package com.milad.module2_3;

import java.util.Comparator;

public class SortBySuits implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        // I sorted suits by using their enum order from .ordinal
        int suit1 = o1.getSuit().ordinal();
        int suit2 = o2.getSuit().ordinal();

        if (suit1 > suit2){
            return 1;
        } else if (suit1 < suit2) {
            return -1;
        }
        return 0;
    }
}
