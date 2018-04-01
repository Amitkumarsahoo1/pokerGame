package com.android.game.pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Prateek on 22-03-2018.
 */

public class CardUtility {

    /**
     * Identifies Hand
     * Sequence
     * Royal Flush
     * Flush
     * Four Of a Kind
     * Three Of a Kind
     * Two Pair
     * Pair
     * High Card
     *
     * @param cards
     */
    public static Hand identifyHands(List<Card> cards) {
        if(isRoyalFlush(cards)) {
            return Hand.ROYAL_FLUSH;
        }

        if(isStraightFlush(cards)) {
            return Hand.STRAIGHT_FLUSH;
        }

        if(isFourOfAKind(cards)) {
            return Hand.FOUR_OF_A_KIND;
        }


        if(isFullHouse(cards)) {
            return Hand.FULL_HOUSE;
        }

        if(isFlush(cards)) {
            return Hand.FLUSH;
        }

        if(isStraight(cards)) {
            return Hand.STRAIGHT;
        }

        if(isThreeOfKind(cards)) {
            return Hand.THREE_OF_A_KIND;
        }

        if(isTwoPair(cards)) {
            return Hand.TWO_PAIR;
        }

        if(isPair(cards)) {
            return Hand.PAIR;
        }
        return Hand.HIGH_CARD;
    }

    /**
     * A K Q J 10 : Same Suit - Royal Flush
     *  all in same suit, so color count should be 1
     * @param cards
     * @return
     */
    public static boolean isRoyalFlush(List<Card> cards) {
        //RoyalFlush A K Q J 10
        boolean isAcePresent = false,
                isKingPresent = false,
                isQueenPresent = false,
                isJackPresent = false,
                isTenPresent = false;

        Set<String> cardSuit = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Card currentCard = cards.get(i);
            cardSuit.add(currentCard.getShape());
            switch (currentCard.getCardType()) {
                case Constants.CARD_TYPE_ACE:
                    isAcePresent = true;
                    break;
                case Constants.CARD_TYPE_KING:
                    isKingPresent = true;
                    break;
                case Constants.CARD_TYPE_QUEEN:
                    isQueenPresent = true;
                    break;
                case Constants.CARD_TYPE_JACK:
                    isJackPresent = true;
                    break;
                case Constants.CARD_TYPE_TEN:
                    isTenPresent = true;
                    break;
            }
        }

        return (isAcePresent && isKingPresent && isQueenPresent && isJackPresent && isTenPresent && cardSuit.size() == 1);
    }

    /**
     * Straight Flush
     *
     * 10 9 8 7 6
     * 9 8 7 6 5
     * or Similar, but all in same suit, so suit count should be 1
     * @param cards
     * @return
     */
    public static boolean isStraightFlush(List<Card> cards) {
        List<Integer> cardSequence = new ArrayList<>();
        Set<String> type = new HashSet<>();

        for(int i = 0 ; i < cards.size(); i++) {
            int value = cards.get(i).getValue();
            type.add(cards.get(i).getShape());
            cardSequence.add(value);
        }

        Collections.sort(cardSequence);
        for(int i = 0 ; i < 4 ; i++) {
            if(cardSequence.get(i) + 1 != cardSequence.get(i+1)) {
                return false;
            }
        }
        return (type.size() == 1);
    }

    public static boolean isFourOfAKind(List<Card> cards) {
        Map<String,Integer> map = getMapOfCardsByCardType(cards);

        if(map.size() != 2)  {
            return false;
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 4) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFullHouse(List<Card> cards) {
        Map<String,Integer> map = getMapOfCardsByCardType(cards);
        return map.size() == 2;
    }

    /**
     *   Flush
     *
     * All Spades, or all heart or all club or all diamond
     * 5 cards of same suit
     * @param cards
     * @return
     */
    public static boolean isFlush(List<Card> cards) {
        Set<String> type = new HashSet<>();

        for(int i = 0 ; i < cards.size(); i++) {
            type.add(cards.get(i).getShape());
        }
        return (type.size() == 1);
    }

    /**
     * Straight
     *
     * 10 9 8 7 6
     * 9 8 7 6 5
     * or Similar, not in same suit
     * @param cards
     * @return
     */
    public static boolean isStraight(List<Card> cards) {
        List<Integer> cardSequence = new ArrayList<>();
        Set<String> type = new HashSet<>();

        for(int i = 0 ; i < cards.size(); i++) {
            int value = cards.get(i).getValue();
            type.add(cards.get(i).getShape());
            cardSequence.add(value);
        }

        Collections.sort(cardSequence);
        for(int i = 0 ; i < 4 ; i++) {
            if(cardSequence.get(i) + 1 != cardSequence.get(i+1)) {
                return false;
            }
        }
        return (type.size() > 1);
    }

    /**
     * 3 of a Kind
     * 3 card of same type (example 3 Ace's or 3 10's)
     * @param cards
     * @return
     */
    public static boolean isThreeOfKind(List<Card> cards) {
        Map<String,Integer> map = getMapOfCardsByCardType(cards);

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 3) {
                return true;
            }
        }

        return false;
    }

    /**
     * 2 Pairs
     * Pair of any Kind (Jack & Jack) & (King & King)
     * @param cards
     * @return
     */
    public static boolean isTwoPair(List<Card> cards) {
        Map<String,Integer> map = getMapOfCardsByCardType(cards);
        int count = 0;

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 2) {
                count = count + 1;
            }
        }

        return count == 2;
    }


    /**
     * Pair : Example 2 10's
     * @param cards
     * @return
     */
    public static boolean isPair(List<Card> cards) {
        Map<String,Integer> map = getMapOfCardsByCardType(cards);
        int count = 0;

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 2) {
                count = count + 1;
            }
        }

        return count == 1;
    }

    /**
     * Get Highest Card from a set of cards
     * @param cards
     * @return
     */
    public static Card getHighestCard(List<Card> cards) {
        Card maxCard = null;
        int maxValue = -1;

        for(Card card : cards) {
            if(card.getValue() > maxValue) {
                maxValue = card.getValue();
                maxCard = card;
            }
        }

        return maxCard;
    }

    public static Map<String,Integer> getMapOfCardsByCardType(List<Card> cards) {
        Map<String,Integer> map = new HashMap<>();

        for(int i = 0 ; i < cards.size(); i++) {
            Card card = cards.get(i);
            Integer cardValue = map.get(card.getCardType());
            if (null == cardValue) {
                cardValue = 0;
            }
            cardValue = cardValue + 1;
            map.put(card.getCardType(),cardValue);
        }
        return map;
    }

    public static Map<Card,Integer> getMapOfCardsWithCardKeyByCardType(List<Card> cards) {
        Map<Card,Integer> map = new HashMap<>();

        for(int i = 0 ; i < cards.size(); i++) {
            Card card = cards.get(i);
            Integer cardValue = map.get(card.getCardType());
            if (null == cardValue) {
                cardValue = 0;
            }
            cardValue = cardValue + 1;
            map.put(card,cardValue);
        }
        return map;
    }

    public static int getSumOfCardValues(List<Card> cards) {
        int count = 0;
        for(int i = 0 ; i < cards.size(); i++) {
            count += cards.get(i).getValue();
        }
        return count;
    }

    public static void main(String g[]) {
        List<Card> cards = new ArrayList<>();
        cards.add(Card.ACE_CLUB_BLACK);
        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.QUEEN_CLUB_BLACK);
        cards.add(Card.JACK_DIAMOND_RED);
        cards.add(Card.TEN_DIAMOND_RED);

        System.out.println("Is Royal Flush " + isRoyalFlush(cards));
        System.out.println("Is Flush " + isStraightFlush(cards));
    }
}
