package com.example.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Cards> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Cards(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Cards draw() {
        return cards.remove(0);
    }

    public void reset() {
        cards.clear();
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Cards(suit, rank));
            }
        }
    }

    public int size() {
        return cards.size();
    }
}
