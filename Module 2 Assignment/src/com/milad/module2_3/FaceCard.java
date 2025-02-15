package com.milad.module2_3;

public enum FaceCard {
    JACK("Jack", 11), QUEEN("Queen", 12), KING("King", 13);

    private final String cardName;
    private final int cardValue;

    FaceCard(String cardName, int cardValue) {
        this.cardName = cardName;
        this.cardValue = cardValue;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return "Face card of " + cardName + " with a value of " + cardValue;
    }
}
