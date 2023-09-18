package com.poker;

import java.util.List;

public class PokerApp {
	public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        List<Card> hand = deck.dealHand(5);

        System.out.println("Shuffling... Shuffling... Shuffling...");
        System.out.print("Your hand: ");
        for (Card card : hand) {
            System.out.print(card + " ");
        }
        System.out.println();

        String result = PokerHandEvaluator.evaluateHand(hand);
        System.out.println("You have: " + result);
    }
}
