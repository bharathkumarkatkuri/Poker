package com.poker;

import java.util.Collections;
import java.util.List;
public class PokerHandEvaluator {

	 public static String evaluateHand(List<Card> hand) {
	        Collections.sort(hand, (c1, c2) -> c1.toString().compareTo(c2.toString()));

	        if (isStraightFlush(hand)) return "Straight Flush";
	        if (isFourOfAKind(hand)) return "Four of a Kind";
	        if (isFullHouse(hand)) return "Full House";
	        if (isFlush(hand)) return "Flush";
	        if (isStraight(hand)) return "Straight";
	        if (isThreeOfAKind(hand)) return "Three of a Kind";
	        if (isTwoPair(hand)) return "Two Pair";
	        if (isOnePair(hand)) return "One Pair";
	        
	        return "High Cards";
	    }

	    private static boolean isStraightFlush(List<Card> hand) {
	        return isStraight(hand) && isFlush(hand);
	    }

	    private static boolean isFourOfAKind(List<Card> hand) {
	        for (int i = 0; i <= 1; i++) {
	            int count = 0;
	            for (int j = 0; j < hand.size(); j++) {
	                if (hand.get(j).rank.equals(hand.get(i).rank)) {
	                    count++;
	                }
	            }
	            if (count == 4) return true;
	        }
	        return false;
	    }

	    private static boolean isFullHouse(List<Card> hand) {
	        return (hand.get(0).rank.equals(hand.get(1).rank) && hand.get(3).rank.equals(hand.get(4).rank))
	            || (hand.get(0).rank.equals(hand.get(1).rank) && hand.get(2).rank.equals(hand.get(4).rank));
	    }

	    private static boolean isFlush(List<Card> hand) {
	        for (int i = 1; i < hand.size(); i++) {
	            if (!hand.get(i).suit.equals(hand.get(0).suit)) return false;
	        }
	        return true;
	    }

	    private static boolean isStraight(List<Card> hand) {
	        for (int i = 1; i < hand.size(); i++) {
	            if (Integer.parseInt(hand.get(i).rank) != Integer.parseInt(hand.get(i - 1).rank) + 1) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private static boolean isThreeOfAKind(List<Card> hand) {
	        for (int i = 0; i <= 2; i++) {
	            int count = 0;
	            for (int j = 0; j < hand.size(); j++) {
	                if (hand.get(j).rank.equals(hand.get(i).rank)) {
	                    count++;
	                }
	            }
	            if (count == 3) return true;
	        }
	        return false;
	    }

	    private static boolean isTwoPair(List<Card> hand) {
	        int pairCount = 0;
	        for (int i = 0; i < hand.size(); i++) {
	            int count = 0;
	            for (int j = i; j < hand.size(); j++) {
	                if (hand.get(j).rank.equals(hand.get(i).rank)) {
	                    count++;
	                }
	            }
	            if (count == 2) {
	                pairCount++;
	                i++;
	            }
	        }
	        return pairCount == 2;
	    }

	    private static boolean isOnePair(List<Card> hand) {
	        for (int i = 0; i < hand.size(); i++) {
	            int count = 0;
	            for (int j = i; j < hand.size(); j++) {
	                if (hand.get(j).rank.equals(hand.get(i).rank)) {
	                    count++;
	                }
	            }
	            if (count == 2) return true;
	        }
	        return false;
	    }
}
