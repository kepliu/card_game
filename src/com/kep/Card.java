package com.kep;

final public class Card implements Comparable<Card> {
    final private int suit;
    final private int rank;
    final String[] suit_names = {"Spade", "Diamond", "Heart", "Club"};
    final String[] rank_names = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuitName() {
        return suit_names[suit];
    }

    public String getRankName() {
        return rank_names[rank];
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        if (this.suit - o.suit == 0) {
            return this.rank - o.rank;
        } else {
            return this.suit - o.suit;
        }

    }
}
