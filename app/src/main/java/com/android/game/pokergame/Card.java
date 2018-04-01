package com.android.game.pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Prateek on 22-03-2018.
 */

public enum Card {

    ACE_CLUB_BLACK(1,"ACE_DIAMOND_RED","Ace of Club",Constants.CARD_TYPE_ACE, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,14, R.drawable.aceofclubs),
    ACE_DIAMOND_RED(2,"ACE_DIAMOND_RED","Ace of Diamond",Constants.CARD_TYPE_ACE, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,14, R.drawable.aceofdiamonds),
    ACE_HEART_RED(3,"ACE_HEART_RED","Ace of Heart",Constants.CARD_TYPE_ACE, Constants.COLOR_RED, Constants.SHAPE_HEART,14, R.drawable.aceofhearts),
    ACE_SPADE_BLACK(4,"ACE_SPADE_BLACK","Ace of Spade",Constants.CARD_TYPE_ACE, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,14, R.drawable.aceofspades),

    KING_CLUB_BLACK(5,"KING_CLUB_BLACK","King of Club",Constants.CARD_TYPE_KING, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,13, R.drawable.kingofclubs),
    KING_DIAMOND_RED(6,"KING_DIAMOND_RED","King of Diamond",Constants.CARD_TYPE_KING, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,13, R.drawable.kingofdiamonds),
    KING_HEART_RED(7,"KING_HEART_RED","King of Heart",Constants.CARD_TYPE_KING, Constants.COLOR_RED, Constants.SHAPE_HEART,13, R.drawable.kingofhearts),
    KING_SPADE_BLACK(8,"KING_SPADE_BLACK","King of Spade",Constants.CARD_TYPE_KING, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,13, R.drawable.kingofspades),

    QUEEN_CLUB_BLACK(9,"QUEEN_CLUB_BLACK","Queen of Club",Constants.CARD_TYPE_QUEEN, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,12, R.drawable.queenofclubs),
    QUEEN_DIAMOND_RED(10,"QUEEN_DIAMOND_RED","Queen of Diamond",Constants.CARD_TYPE_QUEEN, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,12, R.drawable.queenofdiamonds),
    QUEEN_HEART_RED(11,"QUEEN_HEART_RED","Queen of Heart",Constants.CARD_TYPE_QUEEN, Constants.COLOR_RED, Constants.SHAPE_HEART,12, R.drawable.queenofhearts),
    QUEEN_SPADE_BLACK(12,"QUEEN_SPADE_BLACK","Queen of Spade",Constants.CARD_TYPE_QUEEN, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,12, R.drawable.queenofspades),

    JACK_CLUB_BLACK(13,"JACK_CLUB_BLACK","Jack of Club",Constants.CARD_TYPE_JACK, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,11, R.drawable.jackofclubs),
    JACK_DIAMOND_RED(14,"JACK_DIAMOND_RED","Jack of Diamond",Constants.CARD_TYPE_JACK, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,11, R.drawable.jackofdiamonds),
    JACK_HEART_RED(15,"JACK_HEART_RED","Jack of Heart",Constants.CARD_TYPE_JACK, Constants.COLOR_RED, Constants.SHAPE_HEART,11, R.drawable.jackofhearts),
    JACK_SPADE_BLACK(16,"JACK_SPADE_BLACK","Jack of Spade",Constants.CARD_TYPE_JACK, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,11, R.drawable.jackofspades),

    TEN_CLUB_BLACK(17,"TEN_CLUB_BLACK","Ten of Club",Constants.CARD_TYPE_TEN, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,10, R.drawable.tenofclubs),
    TEN_DIAMOND_RED(18,"TEN_DIAMOND_RED","Ten of Diamond",Constants.CARD_TYPE_TEN, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,10, R.drawable.tenofdiamonds),
    TEN_HEART_RED(19,"TEN_HEART_RED","Ten of Heart",Constants.CARD_TYPE_TEN, Constants.COLOR_RED, Constants.SHAPE_HEART,10, R.drawable.tenofhearts),
    TEN_SPADE_BLACK(20,"TEN_SPADE_BLACK","Ten of Spade",Constants.CARD_TYPE_TEN, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,10, R.drawable.tenofspades),

    NINE_CLUB_BLACK(21,"NINE_CLUB_BLACK","Nine of Club",Constants.CARD_TYPE_NINE, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,9, R.drawable.nineofclubs),
    NINE_DIAMOND_RED(22,"NINE_DIAMOND_RED","Nine of Diamond",Constants.CARD_TYPE_NINE, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,9, R.drawable.nineofdiamonds),
    NINE_HEART_RED(23,"NINE_HEART_RED","Nine of Heart",Constants.CARD_TYPE_NINE, Constants.COLOR_RED, Constants.SHAPE_HEART,9, R.drawable.nineofhearts),
    NINE_SPADE_BLACK(24,"NINE_SPADE_BLACK","Nine of Spade",Constants.CARD_TYPE_NINE, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,9, R.drawable.nineofspades),

    EIGHT_CLUB_BLACK(25,"EIGHT_CLUB_BLACK","Eight of Club",Constants.CARD_TYPE_EIGHT, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,8, R.drawable.eightofclubs),
    EIGHT_DIAMOND_RED(26,"EIGHT_DIAMOND_RED","Eight of Diamond",Constants.CARD_TYPE_EIGHT, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,8, R.drawable.eightofdiamonds),
    EIGHT_HEART_RED(27,"EIGHT_HEART_RED","Eight of Heart",Constants.CARD_TYPE_EIGHT, Constants.COLOR_RED, Constants.SHAPE_HEART,8, R.drawable.eightofhearts),
    EIGHT_SPADE_BLACK(28,"EIGHT_SPADE_BLACK","Eight of Spade",Constants.CARD_TYPE_EIGHT, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,8, R.drawable.eightofspades),

    SEVEN_CLUB_BLACK(29,"SEVEN_CLUB_BLACK","Seven of Club",Constants.CARD_TYPE_SEVEN, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,7, R.drawable.sevenofclubs),
    SEVEN_DIAMOND_RED(30,"SEVEN_DIAMOND_RED","Seven of Diamond",Constants.CARD_TYPE_SEVEN, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,7, R.drawable.sevenofdiamonds),
    SEVEN_HEART_RED(31,"SEVEN_HEART_RED","Seven of Heart",Constants.CARD_TYPE_SEVEN, Constants.COLOR_RED, Constants.SHAPE_HEART,7, R.drawable.sevenofhearts),
    SEVEN_SPADE_BLACK(32,"SEVEN_SPADE_BLACK","Seven of Spade",Constants.CARD_TYPE_SEVEN, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,7, R.drawable.sevenofspades),

    SIX_CLUB_BLACK(33,"SIX_CLUB_BLACK","Six of Club",Constants.CARD_TYPE_SIX, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,6, R.drawable.sixofclubs),
    SIX_DIAMOND_RED(34,"SIX_DIAMOND_RED","Six of Diamond",Constants.CARD_TYPE_SIX, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,6, R.drawable.sixofdiamonds),
    SIX_HEART_RED(35,"SIX_HEART_RED","Six of Heart",Constants.CARD_TYPE_SIX, Constants.COLOR_RED, Constants.SHAPE_HEART,6, R.drawable.sixofhearts),
    SIX_SPADE_BLACK(36,"SIX_SPADE_BLACK","Six of Spade",Constants.CARD_TYPE_SIX, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,6, R.drawable.sixofspades),

    FIVE_CLUB_BLACK(37,"FIVE_CLUB_BLACK","Five of Club",Constants.CARD_TYPE_FIVE, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,5, R.drawable.fiveofclubs),
    FIVE_DIAMOND_RED(38,"FIVE_DIAMOND_RED","Five of Diamond",Constants.CARD_TYPE_FIVE, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,5, R.drawable.fiveofdiamonds),
    FIVE_HEART_RED(39,"FIVE_HEART_RED","Five of Heart",Constants.CARD_TYPE_FIVE, Constants.COLOR_RED, Constants.SHAPE_HEART,5, R.drawable.fiveofhearts),
    FIVE_SPADE_BLACK(40,"FIVE_SPADE_BLACK","Five of Spade",Constants.CARD_TYPE_FIVE, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,5, R.drawable.fiveofspades),

    FOUR_CLUB_BLACK(41,"FOUR_CLUB_BLACK","Four of Club",Constants.CARD_TYPE_FOUR, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,4, R.drawable.fourofclubs),
    FOUR_DIAMOND_RED(42,"FOUR_DIAMOND_RED","Four of Diamond",Constants.CARD_TYPE_FOUR, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,4, R.drawable.fourofdiamonds),
    FOUR_HEART_RED(43,"FOUR_HEART_RED","Four of Heart",Constants.CARD_TYPE_FOUR, Constants.COLOR_RED, Constants.SHAPE_HEART,4, R.drawable.fourofhearts),
    FOUR_SPADE_BLACK(44,"FOUR_SPADE_BLACK","Four of Spade",Constants.CARD_TYPE_FOUR, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,4, R.drawable.fourofspades),

    THREE_CLUB_BLACK(45,"THREE_CLUB_BLACK","Three of Club",Constants.CARD_TYPE_THREE, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,3, R.drawable.threeofclubs),
    THREE_DIAMOND_RED(46,"THREE_DIAMOND_RED","Three of Diamond",Constants.CARD_TYPE_THREE, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,3, R.drawable.threeofdiamonds),
    THREE_HEART_RED(47,"THREE_HEART_RED","Three of Heart",Constants.CARD_TYPE_THREE, Constants.COLOR_RED, Constants.SHAPE_HEART,3, R.drawable.threeofhearts),
    THREE_SPADE_BLACK(48,"THREE_SPADE_BLACK","Three of Spade",Constants.CARD_TYPE_THREE, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,3, R.drawable.threeofspades),

    TWO_CLUB_BLACK(49,"TWO_CLUB_BLACK","Two of Club",Constants.CARD_TYPE_TWO, Constants.COLOR_BLACK, Constants.SHAPE_CLUB,2, R.drawable.deuceofclubs),
    TWO_DIAMOND_RED(50,"TWO_DIAMOND_RED","Two of Diamond",Constants.CARD_TYPE_TWO, Constants.COLOR_RED, Constants.SHAPE_DIAMOND,2, R.drawable.deuceofdiamonds),
    TWO_HEART_RED(51,"TWO_HEART_RED","Two of Heart",Constants.CARD_TYPE_TWO, Constants.COLOR_RED, Constants.SHAPE_HEART,2, R.drawable.deuceofhearts),
    TWO_SPADE_BLACK(52,"TWO_SPADE_BLACK","Two of Spade",Constants.CARD_TYPE_TWO, Constants.COLOR_BLACK, Constants.SHAPE_SPADE,2, R.drawable.deuceofspades)
    ;

    private int sequenceNumber;
    private String cardType;
    private String displayName;
    private String name;
    private String color;
    private String shape;
    private int value;
    private int drawableValue;

    Card(int sequenceNumber,String name,String displayName,String cardType, String color, String shape, int value, int drawableValue) {
        this.sequenceNumber = sequenceNumber;
        this.name = name;
        this.displayName = displayName;
        this.cardType = cardType;
        this.color = color;
        this.shape = shape;
        this.value = value;
        this.drawableValue = drawableValue;
    }

    public static List<Card> findByCardType(String cardType) {
        List<Card> cards = new ArrayList<>();
        for(Card c : Card.values()) {
            if(c.getCardType().equals(cardType)){
                cards.add(c);
            }
        }
        return cards;
    }

    public static Map<String,List<Card>> getMapOfCardByKind() {
        Map<String,List<Card>> cards = new HashMap<>();
        for(Card c : Card.values()) {
            List<Card> cardsInMap = cards.get(c.getCardType());
            if(null == cardsInMap) {
                cardsInMap = new ArrayList<>();
                cards.put(c.getCardType(), cardsInMap);
            }
            cardsInMap.add(c);
        }
        return cards;
    }
    public static Card findBySequenceNumber(int sequnceNumber) {
        for(Card c : Card.values()) {
            if(c.getSequenceNumber() == sequnceNumber) {
                return c;
            }
        }
        return null;
    }


    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDrawableValue() {
        return drawableValue;
    }

    public void setDrawableValue(int drawableValue) {
        this.drawableValue = drawableValue;
    }


}
