package com.kep;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Deck {



    private Stack<Card> cards;
    private  Stack<Card> shuffleNumbers(List<Integer> numbers){
       // System.out.println(numbers);
        Collections.shuffle(numbers);
       // System.out.println("Collections.shuffle(numbers)");
       // System.out.println(numbers);
        Stack<Card> cards = new Stack<>();
        for (int num: numbers){
            int suit = num / 13;
            int rank = num % 13;
            cards.push(new Card(suit, rank));
        }
        return cards;
    }
    public  void shuffle(){

        List<Integer> convertedNumbers = new ArrayList<>();
        for (Card c : cards){
            convertedNumbers.add(c.getSuit()*13 + c.getRank());
        }

        cards = shuffleNumbers(convertedNumbers);

    }

    // This constructor generates shuffled cards
    public Deck() {
        cards = new Stack<>();
        List<Integer> rNumbers = Arrays.asList(0, 1, 2, 3,4,5,6,7,8,9,10,11,12,
                                        13,14,15,16,17,18,19,20,21,22,23,24, 25,
                                        26,27,28,29,30,31,32,33,34,35,36,37,38,
                                        39,40,41,42,43,44,45,46,47,48,49,50,51);

        for (int i : rNumbers) {
            int suit = i / 13;
            int rank = i % 13;
            cards.push(new Card(suit, rank));
        }
    }

    public Deck(Stack<Card> cards) {
        this.cards = cards;
    }



    public Stack<Card> getCards() {
        return cards;
    }

    public boolean win(Deck that){
        int thisScore = 0;
        int thatScore = 0;
        while (!cards.empty()){
            Card c = cards.pop();
            thisScore = thisScore + (c.getSuit() + 1) * c.getRank(); //suits are o, 1, 2, 3
        }
        Stack<Card> thatCards = that.getCards();
        while (!thatCards.empty()){
            Card c = thatCards.pop();
            thatScore = thatScore + (c.getSuit() + 1) * c.getRank(); //suits are o, 1, 2, 3
        }
        return thisScore > thatScore;
    }
}
