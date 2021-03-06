package com.kep;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class DeckTest {
    @Test
    public void testNewDeckOf52Cards() {
        Deck deck = new Deck();
        deck.shuffle();
        Stack<Card> cards = deck.getCards();
        //System.out.println(cards);
        List<Card> spades = new ArrayList<>();
        List<Card> diamonds = new ArrayList<>();
        List<Card> hearts = new ArrayList<>();
        List<Card> clubs = new ArrayList<>();

        while (!cards.empty()) {

            Card c = cards.pop();
            //System.out.println(c);
            switch (c.getSuitName()) {
                case "Spade":
                    spades.add(c);
                    break;
                case "Diamond":
                    diamonds.add(c);
                    break;
                case "Heart":
                    hearts.add(c);
                    break;
                case "Club":
                    clubs.add(c);
                    break;
            }

        }
        assertEquals(13, spades.size());
        assertEquals(13, diamonds.size());
        assertEquals(13, hearts.size());
        assertEquals(13, clubs.size());


    }
    @Test
    public void sort(){
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck);
        Stack<Card> cards = deck.getCards();
        List<Card> lCards = new ArrayList<>();
        lCards.addAll(cards);
        System.out.println("Before sorting ");
        System.out.println(lCards);
        Collections.sort(lCards);
        System.out.println("After sorting ");
        System.out.println(lCards);
    }
    @Test
    public void determineWinner(){
        Deck deck = new Deck();
        deck.shuffle();

        Stack<Card> cards = deck.getCards();
        System.out.println(cards);
        Stack<Card>  cards_playerA = new Stack<>();
        Stack<Card>  cards_playerB = new Stack<>();
        cards_playerA.push(cards.pop());
        cards_playerB.push(cards.pop());
        cards_playerA.push(cards.pop());
        cards_playerB.push(cards.pop());
        cards_playerA.push(cards.pop());
        cards_playerB.push(cards.pop());
        System.out.println("cards_playerA: " + cards_playerA);
        System.out.println("cards_playerB:" + cards_playerB);
        Deck deckA = new Deck(cards_playerA);
        Deck deckB = new Deck(cards_playerB);
        System.out.println("playA won? " + deckA.win(deckB));

    }

}

