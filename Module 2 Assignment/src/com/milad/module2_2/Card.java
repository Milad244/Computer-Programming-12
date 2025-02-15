package com.milad.module2_2;

public class Card {
    private final int numberCard;
    private final FaceCard faceCard;
    private final Suit suit;

    Card(int numberCard, Suit suit) {
        this.numberCard = numberCard;
        faceCard = null;
        this.suit = suit;
    }

    Card(FaceCard faceCard, Suit suit) {
        this.faceCard = faceCard;
        numberCard = 0;
        this.suit = suit;
    }

    @Override
    public String toString() {
        if (faceCard != null) {
            return "Face card " + faceCard.getCardName() + " of " + suit.getSuitName() + " with a value of " + faceCard.getCardValue();
        }
        return "Number card " + numberCard + " of " + suit.getSuitName() + " with a value of " + numberCard;
    }
}
