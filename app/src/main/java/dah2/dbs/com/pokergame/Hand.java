package dah2.dbs.com.pokergame;

/**
 * Created by Prateek on 23-03-2018.
 */

public enum Hand {

    ROYAL_FLUSH("Royal Flush",10),
    STRAIGHT_FLUSH("Straight Flush",9),
    FOUR_OF_A_KIND("Four of a Kind",8),
    FULL_HOUSE("Full House", 7),
    FLUSH("Flush", 6),
    STRAIGHT("Straight", 5),
    THREE_OF_A_KIND("Three of a kind" , 4),
    TWO_PAIR("Two pair", 3),
    PAIR("One Pair", 2),
    HIGH_CARD("High Card",1)
    ;

    private int value;
    private String handName;
    Hand(String handName, int value) {
        this.value = value;
        this.handName = handName;
    }

    public int getValue() {
        return value;
    }

    public String getHandName() {
        return handName;
    }
}
