package dah2.dbs.com.pokergame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prateek on 23-03-2018.
 */

public class CardUtilityTest {

    @Test
    public void testIfRoyalFlushPositive() {
        List<Card> cards = new ArrayList<>();
        cards.add(Card.ACE_CLUB_BLACK);
        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.QUEEN_CLUB_BLACK);
        cards.add(Card.JACK_CLUB_BLACK);
        cards.add(Card.TEN_CLUB_BLACK);

        Assert.assertTrue(CardUtility.isRoyalFlush(cards));
        Assert.assertTrue(CardUtility.isStraightFlush(cards));
    }

    @Test
    public void testIfRoyalFlushNegative() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.TEN_DIAMOND_RED);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.JACK_DIAMOND_RED);
        cards.add(Card.QUEEN_DIAMOND_RED);
        cards.add(Card.NINE_DIAMOND_RED);

        Assert.assertFalse(CardUtility.isRoyalFlush(cards));
        Assert.assertTrue(CardUtility.isStraightFlush(cards));
    }

    @Test
    public void testIfFlushNegative() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.QUEEN_CLUB_BLACK);
        cards.add(Card.JACK_DIAMOND_RED);
        cards.add(Card.TEN_DIAMOND_RED);
        cards.add(Card.EIGHT_CLUB_BLACK);

        Assert.assertFalse(CardUtility.isRoyalFlush(cards));
        Assert.assertFalse(CardUtility.isStraightFlush(cards));
    }

    @Test
    public void testFourOfAKindPositive1() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.KING_SPADE_BLACK);
        cards.add(Card.EIGHT_CLUB_BLACK);

        Assert.assertTrue(CardUtility.isFourOfAKind(cards));
    }

    @Test
    public void testFourOfAKindPositive2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.QUEEN_CLUB_BLACK);
        cards.add(Card.QUEEN_DIAMOND_RED);
        cards.add(Card.QUEEN_HEART_RED);
        cards.add(Card.QUEEN_SPADE_BLACK);

        Assert.assertTrue(CardUtility.isFourOfAKind(cards));
    }

    @Test
    public void testFourOfAKindNegative1() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.QUEEN_DIAMOND_RED);
        cards.add(Card.QUEEN_HEART_RED);
        cards.add(Card.QUEEN_SPADE_BLACK);

        Assert.assertFalse(CardUtility.isFourOfAKind(cards));
    }

    @Test
    public void testFourOfAKindNegative2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.TEN_DIAMOND_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.QUEEN_DIAMOND_RED);
        cards.add(Card.FOUR_CLUB_BLACK);
        cards.add(Card.QUEEN_SPADE_BLACK);

        Assert.assertFalse(CardUtility.isFourOfAKind(cards));
    }

    @Test
    public void testFullHouse1() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.QUEEN_DIAMOND_RED);
        cards.add(Card.QUEEN_HEART_RED);
        cards.add(Card.QUEEN_SPADE_BLACK);

        Assert.assertTrue(CardUtility.isFullHouse(cards));
    }

    @Test
    public void testFullHouse2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.TWO_CLUB_BLACK);
        cards.add(Card.TWO_DIAMOND_RED);

        Assert.assertTrue(CardUtility.isFullHouse(cards));
    }

    @Test
    public void testFullHouse3() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.FOUR_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertTrue(CardUtility.isFullHouse(cards));
    }

    @Test
    public void testFullHouseNegative1() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.THREE_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertFalse(CardUtility.isFullHouse(cards));
    }

    @Test
    public void testFullHouseNegative2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.THREE_CLUB_BLACK);
        cards.add(Card.THREE_CLUB_BLACK);
        cards.add(Card.FOUR_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertFalse(CardUtility.isFullHouse(cards));
    }

    @Test
    public void testThreeOfAKind() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.FOUR_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertTrue(CardUtility.isThreeOfKind(cards));
    }

    @Test
    public void testThreeOfAKind2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.KING_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_HEART_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertTrue(CardUtility.isThreeOfKind(cards));
    }

    @Test
    public void testThreeOfAKind3() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.SIX_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.SIX_SPADE_BLACK);
        Assert.assertTrue(CardUtility.isThreeOfKind(cards));
    }


    @Test
    public void testThreeOfAKindNegative() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.SIX_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertFalse(CardUtility.isThreeOfKind(cards));
    }

    @Test
    public void testThreeOfAKindNegative2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.SIX_CLUB_BLACK);
        cards.add(Card.THREE_CLUB_BLACK);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertFalse(CardUtility.isThreeOfKind(cards));
    }

    @Test
    public void testTwoOfAKind() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.SIX_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.KING_HEART_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        Assert.assertTrue(CardUtility.isTwoPair(cards));
    }

    @Test
    public void testTwoOfAKind2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.ACE_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.ACE_HEART_RED);
        Assert.assertTrue(CardUtility.isTwoPair(cards));
    }


    @Test
    public void testTwoOfAKindNegative1() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.ACE_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.FIVE_CLUB_BLACK);
        cards.add(Card.ACE_HEART_RED);
        Assert.assertFalse(CardUtility.isTwoPair(cards));
    }


    @Test
    public void testTwoOfAKindNegative2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.FIVE_DIAMOND_RED);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.FIVE_CLUB_BLACK);
        cards.add(Card.ACE_HEART_RED);
        Assert.assertFalse(CardUtility.isTwoPair(cards));
    }


    @Test
    public void testIfPair() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.SIX_CLUB_BLACK);
        cards.add(Card.SEVEN_CLUB_BLACK);
        cards.add(Card.EIGHT_CLUB_BLACK);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.ACE_HEART_RED);
        Assert.assertTrue(CardUtility.isPair(cards));
    }

    @Test
    public void testIfPair2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.ACE_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.THREE_CLUB_BLACK);
        Assert.assertTrue(CardUtility.isPair(cards));
    }


    @Test
    public void testIfPairNegative() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.ACE_CLUB_BLACK);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.FIVE_CLUB_BLACK);
        cards.add(Card.NINE_CLUB_BLACK);
        Assert.assertFalse(CardUtility.isPair(cards));
    }


    @Test
    public void testIfPairNegative2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.TWO_DIAMOND_RED);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.FIVE_CLUB_BLACK);
        cards.add(Card.EIGHT_CLUB_BLACK);
        Assert.assertFalse(CardUtility.isPair(cards));
    }

    @Test
    public void testMaxCard() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.TWO_DIAMOND_RED);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.FIVE_CLUB_BLACK);
        cards.add(Card.EIGHT_CLUB_BLACK);
        Assert.assertTrue(Card.KING_DIAMOND_RED == CardUtility.getHighestCard(cards));
    }


    @Test
    public void testMaxCard2() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.ACE_HEART_RED);
        cards.add(Card.KING_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        cards.add(Card.FIVE_CLUB_BLACK);
        cards.add(Card.EIGHT_CLUB_BLACK);
        Assert.assertTrue(Card.ACE_HEART_RED == CardUtility.getHighestCard(cards));
    }


    @Test
    public void testMaxCard3() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.FIVE_DIAMOND_RED);
        cards.add(Card.THREE_CLUB_BLACK);
        cards.add(Card.TWO_DIAMOND_RED);
        cards.add(Card.FOUR_SPADE_BLACK);
        cards.add(Card.SIX_HEART_RED);
        Assert.assertTrue(Card.SIX_HEART_RED == CardUtility.getHighestCard(cards));
    }

    @Test
    public void testFlush() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.FIVE_DIAMOND_RED);
        cards.add(Card.THREE_DIAMOND_RED);
        cards.add(Card.TWO_DIAMOND_RED);
        cards.add(Card.FOUR_DIAMOND_RED);
        cards.add(Card.SIX_DIAMOND_RED);
        Assert.assertTrue(CardUtility.isFlush(cards));
    }


    @Test
    public void testFlushNegative() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.FIVE_DIAMOND_RED);
        cards.add(Card.THREE_DIAMOND_RED);
        cards.add(Card.TWO_DIAMOND_RED);
        cards.add(Card.FOUR_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        Assert.assertFalse(CardUtility.isFlush(cards));
    }



    @Test
    public void testStraight() {
        List<Card> cards = new ArrayList<>();

        cards.add(Card.FIVE_DIAMOND_RED);
        cards.add(Card.THREE_DIAMOND_RED);
        cards.add(Card.TWO_DIAMOND_RED);
        cards.add(Card.FOUR_DIAMOND_RED);
        cards.add(Card.SIX_HEART_RED);
        Assert.assertTrue(CardUtility.isStraight(cards));
    }



}
