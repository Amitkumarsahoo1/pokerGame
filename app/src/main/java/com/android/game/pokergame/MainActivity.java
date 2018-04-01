package com.android.game.pokergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button deal;
    private Button compare;
    List<Integer> listOfCardSequence ;
    private ImageView player1Card1,player1Card2,player1Card3,player1Card4,player1Card5;
    private ImageView player2Card1,player2Card2,player2Card3,player2Card4,player2Card5;

    private TextView player1Card1Text,player1Card2Text,player1Card3Text,player1Card4Text,player1Card5Text;
    private TextView player2Card1Text,player2Card2Text,player2Card3Text,player2Card4Text,player2Card5Text;
    private TextView player1ResultTextView,player2ResultTextView,finalResultTextView;
    private List<Card> player1Cards;
    private List<Card> player2Cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFields();
        initCardSequences();
    }

    private void initCardSequences() {

        Set<Integer> randomNumber = new HashSet<Integer>(52);

        for (int i = 1; i<= 52; i++) {
            randomNumber.add(i);
        }

        listOfCardSequence = new ArrayList<>(randomNumber);
    }


    private void initFields() {
        deal = findViewById(R.id.deal);
        compare = findViewById(R.id.compare);

        player1Card1 = findViewById(R.id.player1FirstCard);
        player1Card2 = findViewById(R.id.player1SecondCard);
        player1Card3 = findViewById(R.id.player1ThirdCard);
        player1Card4 = findViewById(R.id.player1FourthCard);
        player1Card5 = findViewById(R.id.player1FifthCard);

        player2Card1 = findViewById(R.id.player2FirstCard);
        player2Card2 = findViewById(R.id.player2SecondCard);
        player2Card3 = findViewById(R.id.player2ThirdCard);
        player2Card4 = findViewById(R.id.player2FourthCard);
        player2Card5 = findViewById(R.id.player2FifthCard);

        player1Card1Text = findViewById(R.id.play1Card1TextView);
        player1Card2Text = findViewById(R.id.play1Card2TextView);
        player1Card3Text = findViewById(R.id.play1Card3TextView);
        player1Card4Text = findViewById(R.id.play1Card4TextView);
        player1Card5Text = findViewById(R.id.play1Card5TextView);

        player2Card1Text = findViewById(R.id.play2Card1TextView);
        player2Card2Text = findViewById(R.id.play2Card2TextView);
        player2Card3Text = findViewById(R.id.play2Card3TextView);
        player2Card4Text = findViewById(R.id.play2Card4TextView);
        player2Card5Text = findViewById(R.id.play2Card5TextView);


        player1ResultTextView = findViewById(R.id.player1ResultTextView);
        player2ResultTextView = findViewById(R.id.player2ResultTextView);
        finalResultTextView = findViewById(R.id.resultValueTextView);

        deal.setOnClickListener(this);
        compare.setOnClickListener(this);
        initValues();
    }

    private void initValues() {
        setTextFieldVisibility(View.INVISIBLE);
        player1Card1Text.setText("");
        player1Card2Text.setText("");
        player1Card3Text.setText("");
        player1Card4Text.setText("");
        player1Card5Text.setText("");
        player2Card1Text.setText("");
        player2Card2Text.setText("");
        player2Card3Text.setText("");
        player2Card4Text.setText("");
        player2Card5Text.setText("");
        player1ResultTextView.setText("");
        player2ResultTextView.setText("");

        player1Card1.setImageResource(R.drawable.back);
        player1Card2.setImageResource(R.drawable.back);
        player1Card3.setImageResource(R.drawable.back);
        player1Card4.setImageResource(R.drawable.back);
        player1Card5.setImageResource(R.drawable.back);

        player2Card1.setImageResource(R.drawable.back);
        player2Card1.setImageResource(R.drawable.back);
        player2Card1.setImageResource(R.drawable.back);
        player2Card1.setImageResource(R.drawable.back);
        player2Card1.setImageResource(R.drawable.back);

        finalResultTextView.setText("");

        player1Cards = new ArrayList<>();
        player2Cards = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.deal:
                initValues();
                setCards();
                deal.setEnabled(false);
                break;

            case R.id.compare:
                compareCards();
                deal.setEnabled(true);
                break;
        }
    }

    private void compareCards() {
        setTextFieldVisibility(View.VISIBLE);
        Hand player1Hand = CardUtility.identifyHands(player1Cards);
        Hand player2Hand = CardUtility.identifyHands(player2Cards);

        String player1Res = player1Hand.getHandName();
        String player2Res = player2Hand.getHandName();

        if(player1Res.equals(Hand.HIGH_CARD.getHandName())) {
            player1Res = "none";
        }

        if(player2Res.equals(Hand.HIGH_CARD.getHandName())) {
            player2Res = "none";
        }

        player1ResultTextView.setText(player1Res);
        player2ResultTextView.setText(player2Res);

        if(player1Hand.getValue() > player2Hand.getValue()) {
            finalResultTextView.setText("Player1's hand is better!");
        } else if(player1Hand.getValue() < player2Hand.getValue()) {
            finalResultTextView.setText("Player2's hand is better!");
        } else {

            int player1CardValueCount = CardUtility.getSumOfCardValues(player1Cards);
            int player2CardValueCount = CardUtility.getSumOfCardValues(player2Cards);

            Map<Card,Integer> player1CardMap = CardUtility.getMapOfCardsWithCardKeyByCardType(player1Cards);
            Map<Card,Integer> player2CardMap = CardUtility.getMapOfCardsWithCardKeyByCardType(player2Cards);
            switch (player1Hand) {

                case STRAIGHT_FLUSH: // 8 7 6 5 4 same suit
                case STRAIGHT: // 10 9 8 7 6
                case HIGH_CARD: // Ace and King
                case FLUSH:
                    //Cards are of same color, Hence highest to lowest sequence of card wins
                    // Example 10S 9S 4S 3S 2S and Ks 10s 9s 7s 3s --> All same but B Wins
                    if(! compareAndGetIfFinalScoreUpdated(player1CardValueCount, player2CardValueCount)) {
                        finalResultTextView.setText("Its a tie"); //Possibility is very less
                    }
                    break;

                case TWO_PAIR: // 2 2 1
                case PAIR: // 2 1 1 1
                    int sumOfCardValueOtherThanPairsPlayer1 = 0,sumOfCardValueOtherThanPairsPlayer2 = 0;

                    int sumOfPairCountPlayer1 = 0,sumOfPairCountPlayer2 = 0;
                    for(Map.Entry<Card,Integer> entry : player1CardMap.entrySet()) {
                        if(entry.getValue() == 2) {
                            sumOfPairCountPlayer1 += entry.getKey().getValue();
                        } else {
                            sumOfCardValueOtherThanPairsPlayer1 += entry.getKey().getValue();
                        }
                    }

                    for(Map.Entry<Card,Integer> entry : player2CardMap.entrySet()) {
                        if(entry.getValue() == 2) {
                            sumOfPairCountPlayer2 += entry.getKey().getValue();
                        } else {
                            sumOfCardValueOtherThanPairsPlayer2 += entry.getKey().getValue();
                        }
                    }

                    if(! compareAndGetIfFinalScoreUpdated(sumOfPairCountPlayer1, sumOfPairCountPlayer2)) {
                        if(! compareAndGetIfFinalScoreUpdated(sumOfCardValueOtherThanPairsPlayer1 , sumOfCardValueOtherThanPairsPlayer2)) {
                            finalResultTextView.setText("Its a tie"); //Possibility is very less
                        }
                    }
                    break;

                    // 3 1 1
                case THREE_OF_A_KIND:
                    int sumOfCardValueOtherThanThreeKindPlayer1 = 0,sumOfCardValueOtherThanThreeKindPlayer2 = 0;
                    int sumOfThreeKindCountPlayer1 = 0,sumOfThreeKindCountPlayer2 = 0;

                    for(Map.Entry<Card,Integer> entry : player1CardMap.entrySet()) {
                        if(entry.getValue() == 3) {
                            sumOfThreeKindCountPlayer1 += entry.getKey().getValue();
                        } else {
                            sumOfCardValueOtherThanThreeKindPlayer1 += entry.getKey().getValue();
                        }
                    }

                    for(Map.Entry<Card,Integer> entry : player2CardMap.entrySet()) {
                        if(entry.getValue() == 3) {
                            sumOfThreeKindCountPlayer1 += entry.getKey().getValue();
                        } else {
                            sumOfCardValueOtherThanThreeKindPlayer2 += entry.getKey().getValue();
                        }
                    }

                    if(! compareAndGetIfFinalScoreUpdated(sumOfThreeKindCountPlayer1, sumOfThreeKindCountPlayer2)) {
                        if(! compareAndGetIfFinalScoreUpdated(sumOfCardValueOtherThanThreeKindPlayer1 , sumOfCardValueOtherThanThreeKindPlayer2)) {
                            finalResultTextView.setText("Its a tie"); //Possibility is very less
                        }
                    }
                    break;
                    //4 1
                case FOUR_OF_A_KIND:
                    int sumOfCardValueOtherThanFourKindPlayer1 = 0,sumOfCardValueOtherThanFourKindPlayer2 = 0;
                    int sumOfFourKindCountPlayer1 = 0,sumOfFourKindCountPlayer2 = 0;

                    for(Map.Entry<Card,Integer> entry : player1CardMap.entrySet()) {
                        if(entry.getValue() == 4) {
                            sumOfFourKindCountPlayer1 += entry.getKey().getValue();
                        } else {
                            sumOfCardValueOtherThanFourKindPlayer1 += entry.getKey().getValue();
                        }
                    }

                    for(Map.Entry<Card,Integer> entry : player2CardMap.entrySet()) {
                        if(entry.getValue() == 4) {
                            sumOfFourKindCountPlayer2 += entry.getKey().getValue();
                        } else {
                            sumOfCardValueOtherThanFourKindPlayer2 += entry.getKey().getValue();
                        }
                    }

                    if(! compareAndGetIfFinalScoreUpdated(sumOfFourKindCountPlayer1, sumOfFourKindCountPlayer2)) {
                        if(! compareAndGetIfFinalScoreUpdated(sumOfCardValueOtherThanFourKindPlayer1 , sumOfCardValueOtherThanFourKindPlayer2)) {
                            finalResultTextView.setText("Its a tie"); //Possibility is very less
                        }
                    }
                    break;

                case ROYAL_FLUSH:
                    finalResultTextView.setText("Its a tie"); //Possibility is very less
                    break;

                case FULL_HOUSE: //3 2
                    if(! compareAndGetIfFinalScoreUpdated(player1CardValueCount, player2CardValueCount)) {
                        //Do nothing, they can never be same
                    }
                    break;
            }
        }
    }

    private boolean compareAndGetIfFinalScoreUpdated(int player1CardValue, int player2CardValue) {
        if(player1CardValue > player2CardValue) {
            finalResultTextView.setText("Player1's hand is better!");
            return true;
        } else if(player1CardValue < player2CardValue) {
            finalResultTextView.setText("Player2's hand is better!");
            return true;
        }
        return false;
    }
    private void setTextFieldVisibility(int visibility) {

        player1Card1Text.setVisibility(visibility);
        player1Card2Text.setVisibility(visibility);
        player1Card3Text.setVisibility(visibility);
        player1Card4Text.setVisibility(visibility);
        player1Card5Text.setVisibility(visibility);

        player2Card1Text.setVisibility(visibility);
        player2Card2Text.setVisibility(visibility);
        player2Card3Text.setVisibility(visibility);
        player2Card4Text.setVisibility(visibility);
        player2Card5Text.setVisibility(visibility);

        player1ResultTextView.setVisibility(visibility);
        player2ResultTextView.setVisibility(visibility);
        finalResultTextView.setVisibility(visibility);
    }
    private void setCards() {
        List<Integer> cardList = getListOfDrawnCards();
        Card player1Card1Card = Card.findBySequenceNumber(cardList.get(0));
        player1Card1.setImageResource(player1Card1Card.getDrawableValue());
        player1Card1.setTag(player1Card1Card.getName());
        player1Card1Text.setText(player1Card1Card.getDisplayName());

        Card player1Card2Card = Card.findBySequenceNumber(cardList.get(1));
        player1Card2.setImageResource(player1Card2Card.getDrawableValue());
        player1Card2.setTag(player1Card2Card.getName());
        player1Card2Text.setText(player1Card2Card.getDisplayName());

        Card player1Card3Card = Card.findBySequenceNumber(cardList.get(2));
        player1Card3.setImageResource(player1Card3Card.getDrawableValue());
        player1Card3.setTag(player1Card3Card.getName());
        player1Card3Text.setText(player1Card3Card.getDisplayName());

        Card player1Card4Card = Card.findBySequenceNumber(cardList.get(3));
        player1Card4.setImageResource(player1Card4Card.getDrawableValue());
        player1Card4.setTag(player1Card4Card.getName());
        player1Card4Text.setText(player1Card4Card.getDisplayName());

        Card player1Card5Card = Card.findBySequenceNumber(cardList.get(4));
        player1Card5.setImageResource(player1Card5Card.getDrawableValue());
        player1Card5.setTag(player1Card5Card.getName());
        player1Card5Text.setText(player1Card5Card.getDisplayName());

        Card player2Card1Card = Card.findBySequenceNumber(cardList.get(5));
        player2Card1.setImageResource(player2Card1Card.getDrawableValue());
        player2Card1.setTag(player2Card1Card.getName());
        player2Card1Text.setText(player2Card1Card.getDisplayName());

        Card player2Card2Card = Card.findBySequenceNumber(cardList.get(6));
        player2Card2.setImageResource(player2Card2Card.getDrawableValue());
        player2Card2.setTag(player2Card2Card.getName());
        player2Card2Text.setText(player2Card2Card.getDisplayName());

        Card player2Card3Card = Card.findBySequenceNumber(cardList.get(7));
        player2Card3.setImageResource(player2Card3Card.getDrawableValue());
        player2Card3.setTag(player2Card3Card.getName());
        player2Card3Text.setText(player2Card3Card.getDisplayName());

        Card player2Card4Card = Card.findBySequenceNumber(cardList.get(8));
        player2Card4.setImageResource(player2Card4Card.getDrawableValue());
        player2Card4.setTag(player2Card4Card.getName());
        player2Card4Text.setText(player2Card4Card.getDisplayName());

        Card player2Card5Card = Card.findBySequenceNumber(cardList.get(9));
        player2Card5.setImageResource(player2Card5Card.getDrawableValue());
        player2Card5.setTag(player2Card5Card.getName());
        player2Card5Text.setText(player2Card5Card.getDisplayName());

        setTextFieldVisibility(View.VISIBLE);

        player1Cards.add(player1Card1Card);
        player1Cards.add(player1Card2Card);
        player1Cards.add(player1Card3Card);
        player1Cards.add(player1Card4Card);
        player1Cards.add(player1Card5Card);

        player2Cards.add(player2Card1Card);
        player2Cards.add(player2Card2Card);
        player2Cards.add(player2Card3Card);
        player2Cards.add(player2Card4Card);
        player2Cards.add(player2Card5Card);
    }

    public List<Integer> getListOfDrawnCards(){
        List<Integer> list = new ArrayList<>(listOfCardSequence);
        Collections.shuffle(list);

        List<Integer> drawnCards = new ArrayList<>();

        Random r = new Random();
        int randomNumber = r.nextInt((100 - 2) + 1) + 2;
        System.out.println("Random number generated is " + randomNumber);

        if(randomNumber % 19 == 0) {
            return getRoyalFlushHand();
        } else if(randomNumber % 17 == 0) {
            return getStraightFlush();
        } else if(randomNumber % 13 == 0) {
            return getStraight();
        } else if(randomNumber % 11 == 0) {
            return getFlush();
        }

        for (int i = 1; i<= 10; i++) {
            drawnCards.add(list.get(i));
        }
        return drawnCards;
    }


    private List<Integer> getRoyalFlushHand() {
        List<Integer> list = new ArrayList<>();
        //player 1 cards
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(13);
        list.add(17);

        //player 2 cards
        list.add(33);
        list.add(44);
        list.add(50);
        list.add(25);
        list.add(39);
        return list;
    }

    private List<Integer> getStraightFlush() {
        List<Integer> list = new ArrayList<>();
        list.add(17);
        list.add(21);
        list.add(25);
        list.add(29);
        list.add(33);

        //player 2 cards
        list.add(33);
        list.add(44);
        list.add(50);
        list.add(25);
        list.add(39);
        return list;
    }

    private List<Integer> getStraight() {
        List<Integer> list = new ArrayList<>();
        list.add(17);
        list.add(22);
        list.add(27);
        list.add(31);
        list.add(34);

        //player 2 cards
        list.add(33);
        list.add(44);
        list.add(50);
        list.add(25);
        list.add(39);
        return list;
    }

    private List<Integer> getFlush() {
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(25);
        list.add(5);
        list.add(9);
        list.add(13);

        //player 2 cards
        list.add(33);
        list.add(44);
        list.add(50);
        list.add(25);
        list.add(39);
        return list;
    }
}
