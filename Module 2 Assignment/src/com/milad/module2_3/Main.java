package com.milad.module2_3;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Card> randomDeck = createCardStack();
        Collections.shuffle(randomDeck);

        System.out.println("Showing the random deck\n");
        for (Card c : randomDeck) {
            System.out.println(c);
        }

        SortBySuits suitsSorter = new SortBySuits();
        LinkedList<Card> sortedBySuitsDeck = (LinkedList<Card>) randomDeck.clone();
        sortedBySuitsDeck.sort(suitsSorter);

        System.out.println("\nShowing the deck ordered by suits\n");
        for (Card c : sortedBySuitsDeck) {
            System.out.println(c);
        }

        SortByFace faceSorter = new SortByFace();
        LinkedList<Card> sortedByFaceCardOrNot = (LinkedList<Card>) randomDeck.clone();
        sortedByFaceCardOrNot.sort(faceSorter);

        System.out.println("\nShowing the deck ordered by whether or not it is a face card\n");
        for (Card c : sortedByFaceCardOrNot) {
            System.out.println(c);
        }
    }

    private static LinkedList<Card> createCardStack() {
        LinkedList<Card> cards = new LinkedList<>();

        for (int i = 1; i < 14; i++){
            if (i < 11) {
                cards.add(new Card(i, Suit.DIAMOND));
                cards.add(new Card(i, Suit.HEART));
                cards.add(new Card(i, Suit.CLUB));
                cards.add(new Card(i, Suit.SPADE));
            } else if (i == 11) {
                cards.add(new Card(FaceCard.JACK, Suit.DIAMOND));
                cards.add(new Card(FaceCard.JACK, Suit.HEART));
                cards.add(new Card(FaceCard.JACK, Suit.CLUB));
                cards.add(new Card(FaceCard.JACK, Suit.SPADE));
            } else if (i == 12) {
                cards.add(new Card(FaceCard.QUEEN, Suit.DIAMOND));
                cards.add(new Card(FaceCard.QUEEN, Suit.HEART));
                cards.add(new Card(FaceCard.QUEEN, Suit.CLUB));
                cards.add(new Card(FaceCard.QUEEN, Suit.SPADE));
            } else {
                cards.add(new Card(FaceCard.KING, Suit.DIAMOND));
                cards.add(new Card(FaceCard.KING, Suit.HEART));
                cards.add(new Card(FaceCard.KING, Suit.CLUB));
                cards.add(new Card(FaceCard.KING, Suit.SPADE));
            }
        }

        return cards;
    }
}
