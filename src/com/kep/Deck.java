package com.kep;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Deck {
    Stack<Card> cards;

    // This constructor generates shuffled cards
    public Deck(int numberOfCards) {
        cards = new Stack<>();
        Random rand = new Random();
        List<Integer> rNumbers = new ArrayList<>();
        int count = 0;
        do {  // get random order of 0 to 51 into the list
            int r = rand.nextInt(52);
            if (!rNumbers.contains(r)) {
                rNumbers.add(r);
            }

        }while (rNumbers.size() != 52);

        //convert numbers to cards
        for (int i=0; i < numberOfCards; i++) {
            int suit = rNumbers.get(i)/ 13;
            int rank = rNumbers.get(i) % 13;
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
