package com.poker;

public class Card {
	
	final String suit;
    final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + suit;
    }

}
