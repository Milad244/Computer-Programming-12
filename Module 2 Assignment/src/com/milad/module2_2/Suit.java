package com.milad.module2_2;

public enum Suit {
    HEART("Hearts"), DIAMOND("Diamonds"), CLUB("Clubs"), SPADE("Spades");

    private final String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return suitName;
    }
}
