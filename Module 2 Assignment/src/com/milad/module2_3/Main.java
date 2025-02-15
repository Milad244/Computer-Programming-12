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

        SortByValue valueSorter = new SortByValue();
        LinkedList<Card> sortedByValueDeck = (LinkedList<Card>) randomDeck.clone();
        sortedByValueDeck.sort(valueSorter);

        System.out.println("\nShowing the deck ordered by value\n");
        for (Card c : sortedByValueDeck) {
            System.out.println(c);
        }
    }

    private static LinkedList<Card> createCardStack() {
        LinkedList<Card> cards = new LinkedList<>();

        for (int i = 0; i < 13; i++){
            if (i < 10) {
                cards.add(new Card(i, Suit.DIAMOND));
                cards.add(new Card(i, Suit.HEART));
                cards.add(new Card(i, Suit.CLUB));
                cards.add(new Card(i, Suit.SPADE));
            } else if (i == 10) {
                cards.add(new Card(FaceCard.JACK, Suit.DIAMOND));
                cards.add(new Card(FaceCard.JACK, Suit.HEART));
                cards.add(new Card(FaceCard.JACK, Suit.CLUB));
                cards.add(new Card(FaceCard.JACK, Suit.SPADE));
            } else if (i == 11) {
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
