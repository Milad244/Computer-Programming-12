package com.milad.module2_2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Card> cards = createCardStack();

        Iterator<Card> iterator = cards.iterator();

        System.out.println("Showing a regular card deck\n");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        LinkedList<Card> cardsForGame = createCardStack();
        Collections.shuffle(cardsForGame);

        System.out.println("\nShowing the master deck before I take my cards\n");
        for (Card c : cardsForGame) {
            System.out.println(c);
        }

        LinkedList<Card> myCards = new LinkedList<>();

        for (int i = 0; i < 7; i++) {
            myCards.add(cardsForGame.pollLast());
        }

        System.out.println("\nShowing my card deck hand\n");
        for (Card c : myCards) {
            System.out.println(c);
        }

        System.out.println("\nShowing the master deck after I take my cards\n");
        for (Card c : cardsForGame) {
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
