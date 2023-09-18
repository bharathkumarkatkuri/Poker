package com.poker;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {

	private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"♣", "♦", "♥", "♠"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> dealHand(int handSize) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            hand.add(cards.remove(0));
        }
        return hand;
    }
}
