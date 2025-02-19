package com.milad.module2_2;

public class Card {
    private final int numberCard;
    private final FaceCard faceCard;
    private final Suit suit;

    /**
     * Card constructor for number card
     * @param numberCard the number of the card as an int. Ace is 1 so only 1-10 is allowed
     * @param suit the suit of the card as a Suit
     */
    public Card(int numberCard, Suit suit) {
        this.numberCard = numberCard;
        faceCard = null;
        this.suit = suit;
    }

    /**
     * Card constructor for face card
     * @param faceCard the type of face of the face card as a faceCard.
     * @param suit the suit of the card as a Suit
     */
    public Card(FaceCard faceCard, Suit suit) {
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
